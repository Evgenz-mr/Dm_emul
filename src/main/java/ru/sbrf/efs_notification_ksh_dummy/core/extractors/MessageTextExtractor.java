package ru.sbrf.efs_notification_ksh_dummy.core.extractors;

import com.ibm.jms.JMSBytesMessage;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Slf4j
public class MessageTextExtractor implements IExtractor<Message, String> {

    @SneakyThrows(JMSException.class)
    public String extract(Message message) {
        String text = null;
        if (message instanceof JMSBytesMessage) {
            log.trace("Extracting text from message of type 'JMSBytesMessage'");
            text = readTextFromJMSBytesMessage((JMSBytesMessage) message);
        } else {
            log.trace("Extracting text from message of type 'TextMessage'");
            text = readTextFromTextMessage((TextMessage) message);
        }
        log.trace("From message with ID '{}' extracted text: {}", message.getJMSMessageID(), text);
        return text;
    }

    @SneakyThrows(JMSException.class)
    String readTextFromJMSBytesMessage(JMSBytesMessage message) {
        int bodyLength = (int) message.getBodyLength();
        byte[] textBytes = new byte[bodyLength];
        message.readBytes(textBytes, bodyLength);
        return new String(textBytes);
    }


    @SneakyThrows(JMSException.class)
    String readTextFromTextMessage(TextMessage message) {
        return message.getText();
    }
}
