package ru.sbrf.efs_notification_ksh_dummy.core.handler;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import ru.sbrf.efs_notification_ksh_dummy.core.delay.DelayUtils;
import ru.sbrf.efs_notification_ksh_dummy.core.extractors.IExtractor;
import ru.sbrf.efs_notification_ksh_dummy.core.influxdb.InfluxDBSender;
import ru.sbrf.efs_notification_ksh_dummy.core.jms.ResponseMessageCreator;
import ru.sbrf.efs_notification_ksh_dummy.core.model.*;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@Slf4j
@Data
public abstract class RequestHandlerBlank implements MessageListener {

    protected JmsTemplate sender;
    protected IExtractor<Message, String> messageTextExtractor;
    protected IExtractor<String, String> operationNameExtractor;
    protected IExtractor<String, String> rqUIDExtractor;
    protected InfluxDBSender<RequestResponsePair<BasicMessageMetadata, Message, BasicMessageMetadata, Message>> influxDBSender;
    protected DelayAmount delay;

    protected  void logReceivedJMSMessageID(Message requestMessage) throws JMSException {
        log.info("Received message with JMSMessageID '{}'", requestMessage.getJMSMessageID());
    }

    protected  void logToInfluxDB(MessageWithMetadata<BasicMessageMetadata, Message> request, MessageWithMetadata<BasicMessageMetadata, Message> response, FlowTimings timings) {
        if (influxDBSender!= null){
            RequestResponsePair<BasicMessageMetadata, Message, BasicMessageMetadata, Message> requestResponsePair = new RequestResponsePair<>(request, response, timings);
            try {
                influxDBSender.send(requestResponsePair);
            } catch (Throwable ex){
                log.error("Exception while trying to send info to InfluxDB", ex);
            }
        }
    }

    protected MessageWithMetadata<BasicMessageMetadata, Message> getSentResponse(ResponseMessageCreator<BasicMessageMetadata, Message, BasicMessageMetadata, Message> responseMessageCreator) {
        long responseTimestamp = System.currentTimeMillis();
        MessageWithMetadata<BasicMessageMetadata, Message> response = responseMessageCreator.getResponse();
        response.getMetadata().setTimestamp(responseTimestamp);
        return response;
    }

    protected  long simulateProcessingDelay() {
        return DelayUtils.delayThisThread(delay);
    }

    @SneakyThrows(JMSException.class)
    protected BasicMessageMetadata extractMetadata(Message message) {
        long timestamp = System.currentTimeMillis();
        String text = messageTextExtractor.extract(message);
        log.trace("JMSMessageID '{}', text '{}'", message.getJMSMessageID(), text);

        String operationName = operationNameExtractor.extract(text);
        log.info("JMSMessageID '{}', operation '{}'", message.getJMSMessageID(), operationName);

        String rqUID = rqUIDExtractor.extract(text);
        log.info("JMSMessageID '{}', RqUID '{}'", message.getJMSMessageID(), rqUID);

        return new BasicMessageMetadata(operationName, rqUID, text, timestamp);
    }

    @SneakyThrows(JMSException.class)
    protected void logSentResponse(MessageWithMetadata<BasicMessageMetadata, Message> response) {
        log.info("Sent JMSMessageID '{}', JMSCorrelationID '{}', operation name '{}'",
                response.getMessage().getJMSMessageID(),
                response.getMessage().getJMSCorrelationID(),
                response.getMetadata().getOperationName());

        log.trace("Sent JMSMessageID '{}', text '{}'",
                response.getMessage().getJMSMessageID(),
                response.getMetadata().getMessageText());
    }
}
