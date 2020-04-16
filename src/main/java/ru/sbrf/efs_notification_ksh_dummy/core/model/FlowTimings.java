package ru.sbrf.efs_notification_ksh_dummy.core.model;

import lombok.Data;

@Data
public class FlowTimings {
    Long receivedTimestamp;
    Long waitingDuration;
    Long requestProcessingDuration;
    Long thinkTimeDuration;
    Long responseCreationDuration;
    Long sendingResponseDuration;
    Long totalDuration;
    Long sentTimestamp;
}
