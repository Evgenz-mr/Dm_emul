package ru.sbrf.efs_notification_ksh_dummy.core.model;

import lombok.Data;

import javax.jms.Message;

@Data
public class MessageWithMetadata<METADATA, MESSAGE extends Message> {
    METADATA metadata;
    MESSAGE message;

    public MessageWithMetadata() {
    }

    public MessageWithMetadata(METADATA metadata, MESSAGE message) {
        this.metadata = metadata;
        this.message = message;
    }
}
