package ru.sbrf.efs_notification_ksh_dummy.core.handler;

import lombok.Data;

import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.concurrent.ExecutorService;

@Data
public class AsyncRequestHandler implements MessageListener {
    ExecutorService threadPool;
    MessageListener handler;

    @Override
    public void onMessage(final Message message) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                handler.onMessage(message);
            }
        });
    }
}
