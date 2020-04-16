package ru.sbrf.efs_notification_ksh_dummy.core.handler;

import lombok.SneakyThrows;
import ru.sbrf.efs_notification_ksh_dummy.core.jms.ResponseMessageCreator;
import ru.sbrf.efs_notification_ksh_dummy.core.model.BasicMessageMetadata;
import ru.sbrf.efs_notification_ksh_dummy.core.model.FlowTimings;
import ru.sbrf.efs_notification_ksh_dummy.core.model.MessageWithMetadata;

import javax.jms.JMSException;
import javax.jms.Message;

public abstract class DefaultFlowHandler extends RequestHandlerBlank {

    @Override
    @SneakyThrows(JMSException.class)
    public void onMessage(Message requestMessage) {
        long messageReceivedTimestamp = System.currentTimeMillis();
        logReceivedJMSMessageID(requestMessage);
        BasicMessageMetadata requestMetadata = extractMetadata(requestMessage);
        MessageWithMetadata<BasicMessageMetadata, Message> request = new MessageWithMetadata<>(requestMetadata, requestMessage);
        ResponseMessageCreator<BasicMessageMetadata, Message, BasicMessageMetadata, Message> responseMessageCreator = createResponseMessageCreator(request);
        long requestProcessingEndTimestamp= System.currentTimeMillis();
        if (responseMessageCreator == null) {
            FlowTimings flowTimings = new FlowTimings();
            flowTimings.setWaitingDuration(0L);
            flowTimings.setReceivedTimestamp(messageReceivedTimestamp);
            flowTimings.setRequestProcessingDuration(requestProcessingEndTimestamp - messageReceivedTimestamp);
            flowTimings.setTotalDuration(System.currentTimeMillis() - requestProcessingEndTimestamp);
            //logToInfluxDB(request, null, flowTimings);
            return;
        }
        long thinkTimeDuration = simulateProcessingDelay();
        long startSendingTimestamp = System.currentTimeMillis();
        sender.send(responseMessageCreator);
        long endSendingTimestamp = System.currentTimeMillis();
        long responseCreationDuration = responseMessageCreator.getResponseMessageCreationDuration();
        long sendingResponseDuration = endSendingTimestamp - startSendingTimestamp - responseCreationDuration;
        long totalDuration = endSendingTimestamp - messageReceivedTimestamp;
        MessageWithMetadata<BasicMessageMetadata, Message> response = responseMessageCreator.getResponse();
        logSentResponse(response);

        FlowTimings flowTimings = new FlowTimings();
        flowTimings.setReceivedTimestamp(messageReceivedTimestamp);
        flowTimings.setWaitingDuration(0L);
        flowTimings.setRequestProcessingDuration(requestProcessingEndTimestamp - messageReceivedTimestamp);
        flowTimings.setThinkTimeDuration(thinkTimeDuration);
        flowTimings.setResponseCreationDuration(responseCreationDuration);
        flowTimings.setSendingResponseDuration(sendingResponseDuration);
        flowTimings.setTotalDuration(totalDuration);
        flowTimings.setSentTimestamp(endSendingTimestamp);
        //logToInfluxDB(request, response, flowTimings);
    }

    protected abstract ResponseMessageCreator<BasicMessageMetadata, Message, BasicMessageMetadata, Message> createResponseMessageCreator(MessageWithMetadata<BasicMessageMetadata, Message> request);
}
