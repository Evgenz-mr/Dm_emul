package ru.sbrf.efs_notification_ksh_dummy.core.jms;

import ru.sbrf.efs_notification_ksh_dummy.core.model.MessageWithMetadata;

import javax.jms.Message;
import javax.jms.Session;

public interface MessageWithMetadataCreator<METADATA, MESSAGE extends Message> {
    MessageWithMetadata<METADATA, MESSAGE> createMessageWithMetadata(Session session);
}
