package ru.sbrf.efs_notification_ksh_dummy.core.jms;


import lombok.Getter;
import lombok.SneakyThrows;
import org.springframework.jms.core.MessageCreator;
import ru.sbrf.efs_notification_ksh_dummy.core.model.MessageWithMetadata;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

public abstract class ResponseMessageCreator<REQUEST_METADATA, REQUEST_MESSAGE extends Message, RESPONSE_METADATA, RESPONSE_MESSAGE extends Message> implements MessageWithMetadataCreator<RESPONSE_METADATA, RESPONSE_MESSAGE>, MessageCreator {
    @Getter
    protected MessageWithMetadata<REQUEST_METADATA, REQUEST_MESSAGE> request;
    @Getter
    protected MessageWithMetadata<RESPONSE_METADATA, RESPONSE_MESSAGE> response;
    @Getter
    protected long responseMessageCreationDuration = 0;

    public ResponseMessageCreator(MessageWithMetadata<REQUEST_METADATA, REQUEST_MESSAGE> request) {
        this.request = request;
    }

    @SneakyThrows(JMSException.class)
    protected RESPONSE_MESSAGE setJMSCorrelationID(RESPONSE_MESSAGE response){
        response.setJMSCorrelationID(request.getMessage().getJMSMessageID());
        return response;
    }

    @SneakyThrows(JMSException.class)
    protected TextMessage createResponseTextMessage(Session session, String text){
        TextMessage textMessage = session.createTextMessage(text);
        setJMSCorrelationID((RESPONSE_MESSAGE) textMessage);
        return textMessage;
    }

    @Override
    public Message createMessage(Session session) throws JMSException {
        long beforeMessageCreatedTimestamp = System.currentTimeMillis();
        this.response = createMessageWithMetadata(session);
        long afterMessageCreatedTimestamp = System.currentTimeMillis();
        this.responseMessageCreationDuration = afterMessageCreatedTimestamp - beforeMessageCreatedTimestamp;
        return response.getMessage();
    }
}
