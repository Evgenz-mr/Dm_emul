package ru.sbrf.efs_notification_ksh_dummy.core.model;

import lombok.Data;

@Data
public class DelayAmount {
    long min;
    long max;

    public DelayAmount() {
    }

    public DelayAmount(int min, int max) {
        this.min = min;
        this.max = max;
    }
}
