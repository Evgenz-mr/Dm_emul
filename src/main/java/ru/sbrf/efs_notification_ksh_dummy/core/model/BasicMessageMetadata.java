package ru.sbrf.efs_notification_ksh_dummy.core.model;

import lombok.Data;

@Data
public class BasicMessageMetadata {
    String operationName;
    String rqUID;
    String messageText;
    Long timestamp;

    public BasicMessageMetadata() {
    }

    public BasicMessageMetadata(String operationName, String rqUID, String messageText) {
        this.operationName = operationName;
        this.rqUID = rqUID;
        this.messageText = messageText;
    }

    public BasicMessageMetadata(String operationName, String rqUID, String messageText, Long timestamp) {
        this.operationName = operationName;
        this.rqUID = rqUID;
        this.messageText = messageText;
        this.timestamp = timestamp;
    }
}
