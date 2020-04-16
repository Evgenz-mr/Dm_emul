package ru.sbrf.efs_notification_ksh_dummy.core.model;

import lombok.Data;

import javax.jms.Message;

@Data
public class RequestResponsePair<REQUEST_METADATA, REQUEST_MESSAGE extends Message, RESPONSE_METADATA, RESPONSE_MESSAGE extends Message> {
    MessageWithMetadata<REQUEST_METADATA, REQUEST_MESSAGE> request;
    MessageWithMetadata<RESPONSE_METADATA, RESPONSE_MESSAGE> response;
    FlowTimings flowTimings;

    public RequestResponsePair() {
    }

    public RequestResponsePair(MessageWithMetadata<REQUEST_METADATA, REQUEST_MESSAGE> request, MessageWithMetadata<RESPONSE_METADATA, RESPONSE_MESSAGE> response, FlowTimings flowTimings) {
        this.request = request;
        this.response = response;
        this.flowTimings = flowTimings;
    }
}
