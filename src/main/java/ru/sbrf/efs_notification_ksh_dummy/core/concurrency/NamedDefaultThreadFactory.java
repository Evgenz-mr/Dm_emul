package ru.sbrf.efs_notification_ksh_dummy.core.concurrency;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/***
 * За основу взят код java.util.concurrent.Executors.DefaultThreadFactory, но добавлен настраиваемый префикс имени очереди.
 */
public class NamedDefaultThreadFactory implements ThreadFactory {
    private static final ConcurrentHashMap<String, AtomicInteger> lastPoolNumberByNamePrefix = new ConcurrentHashMap<>();
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    private final String threadNamePrefix;

    public NamedDefaultThreadFactory(String namePrefix) {
        SecurityManager s = System.getSecurityManager();
        group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
        threadNamePrefix = createThreadNamePrefix(namePrefix);
    }

    public Thread newThread(Runnable r) {
        Thread t = new Thread(group, r, threadNamePrefix + threadNumber.getAndIncrement(), 0);
        if (t.isDaemon())
            t.setDaemon(false);
        if (t.getPriority() != Thread.NORM_PRIORITY)
            t.setPriority(Thread.NORM_PRIORITY);
        return t;
    }

    private String createThreadNamePrefix(String namePrefix) {
        lastPoolNumberByNamePrefix.putIfAbsent(namePrefix, new AtomicInteger(0));
        AtomicInteger lastPoolNumberForNamePrefix = lastPoolNumberByNamePrefix.get(namePrefix);
        int currentPoolNumber = lastPoolNumberForNamePrefix.incrementAndGet();
        return namePrefix + "-pool-" + currentPoolNumber + "-thread-";
    }

}


