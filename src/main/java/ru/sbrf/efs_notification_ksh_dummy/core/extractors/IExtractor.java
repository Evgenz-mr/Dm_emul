package ru.sbrf.efs_notification_ksh_dummy.core.extractors;

public interface IExtractor<FROM, RESULT> {
    RESULT extract(FROM value);
}
