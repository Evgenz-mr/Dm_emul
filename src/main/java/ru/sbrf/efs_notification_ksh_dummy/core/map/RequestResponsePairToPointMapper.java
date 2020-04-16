package ru.sbrf.efs_notification_ksh_dummy.core.map;

import lombok.Data;
import lombok.SneakyThrows;
import org.influxdb.dto.Point;
import ru.sbrf.efs_notification_ksh_dummy.core.model.BasicMessageMetadata;
import ru.sbrf.efs_notification_ksh_dummy.core.model.MessageWithMetadata;
import ru.sbrf.efs_notification_ksh_dummy.core.model.RequestResponsePair;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.concurrent.TimeUnit;

@Data
public class RequestResponsePairToPointMapper implements IMapper<RequestResponsePair<BasicMessageMetadata, Message, BasicMessageMetadata, Message>, Point> {
    String measurement;
    String host;
    String port;
    String queueManager;
    String channel;
    String queueIncome;
    String queueOutgoing;

    @Override
    public Point map(RequestResponsePair<BasicMessageMetadata, Message, BasicMessageMetadata, Message> value) {
        Point.Builder withMeasurement = Point.measurement(measurement);
        Point.Builder withCommonInformation = fillCommonInformation(withMeasurement, value);
        Point.Builder withRequestInformation = fillRequestInformation(withCommonInformation, value);
        Point.Builder withResponseInformation = fillResponseInformation(withRequestInformation, value);
        return withResponseInformation.build();
    }

    Point.Builder fillCommonInformation(Point.Builder builder, RequestResponsePair<BasicMessageMetadata, Message, BasicMessageMetadata, Message> value) {
        Long timestamp = getTimestamp(value);
        return builder
                .time(timestamp, TimeUnit.MILLISECONDS)
                .tag("host", host)
                .tag("port", port)
                .tag("queueManager", queueManager)
                .tag("channel", channel);
    }

    private Long getTimestamp(RequestResponsePair<BasicMessageMetadata, Message, BasicMessageMetadata, Message> value) {
        MessageWithMetadata<BasicMessageMetadata, Message> request = value.getRequest();
        MessageWithMetadata<BasicMessageMetadata, Message> response = value.getResponse();
        Long timestamp;
        if (request != null && request.getMetadata() != null && request.getMetadata().getTimestamp() != null) {
            timestamp = request.getMetadata().getTimestamp();
        } else if (response != null && response.getMetadata() != null && response.getMetadata().getTimestamp() != null) {
            timestamp = response.getMetadata().getTimestamp();
        } else {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

    @SneakyThrows(JMSException.class)
    Point.Builder fillRequestInformation(Point.Builder builder, RequestResponsePair<BasicMessageMetadata, Message, BasicMessageMetadata, Message> value) {
        MessageWithMetadata<BasicMessageMetadata, Message> request = value.getRequest();
        if (request != null && request.getMetadata() != null) {
            Point.Builder withoutRqUID = builder
                    .tag("queueIncome", queueIncome)
                    .tag("operationNameIncome", request.getMetadata().getOperationName())
                    .addField("incomeJMSMessageID", request.getMessage().getJMSMessageID())
                    .addField("timestampIncome", value.getFlowTimings().getReceivedTimestamp())
                    .addField("totalDelay", value.getFlowTimings().getTotalDuration());
            if (request.getMetadata().getRqUID() != null){
                Point.Builder withRqUID = withoutRqUID.addField("rqUID", request.getMetadata().getRqUID());
                return withRqUID;
            }
            return withoutRqUID;
        }
        return builder;
    }

    @SneakyThrows(JMSException.class)
    Point.Builder fillResponseInformation(Point.Builder builder, RequestResponsePair<BasicMessageMetadata, Message, BasicMessageMetadata, Message> value) {
        MessageWithMetadata<BasicMessageMetadata, Message> response = value.getResponse();
        if (response != null && response.getMetadata() != null) {
            return builder
                    .tag("queueOutgoing", queueOutgoing)
                    .tag("operationNameOutgoing", response.getMetadata().getOperationName() == null ? "" : response.getMetadata().getOperationName())
                    .addField("outgoingJMSMessageID", response.getMessage().getJMSMessageID())
                    .addField("timestampOutgoing", value.getFlowTimings().getSentTimestamp())
                    .addField("waitingDuration", value.getFlowTimings().getWaitingDuration())
                    .addField("processingDelay", value.getFlowTimings().getRequestProcessingDuration())
                    .addField("simulatedDelay", value.getFlowTimings().getThinkTimeDuration())
                    .addField("responseCreationDuration", value.getFlowTimings().getResponseCreationDuration())
                    .addField("sendingResponseDuration", value.getFlowTimings().getSendingResponseDuration());
        }
        return builder;
    }
}
