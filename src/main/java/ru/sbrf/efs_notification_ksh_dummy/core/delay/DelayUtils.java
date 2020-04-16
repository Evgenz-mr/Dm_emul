package ru.sbrf.efs_notification_ksh_dummy.core.delay;

import ru.sbrf.efs_notification_ksh_dummy.core.model.DelayAmount;

import static org.apache.commons.lang3.RandomUtils.nextLong;

public class DelayUtils {
    //todo изменить этот костыль на более элегантную реализацию
    public static long delayThisThread(DelayAmount delay){
        long started = System.currentTimeMillis();
        try {
            long realDelay = nextLong(delay.getMin(), delay.getMax());
            Thread.sleep(realDelay);
            return realDelay;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return System.currentTimeMillis() - started;
        }
    }
}
