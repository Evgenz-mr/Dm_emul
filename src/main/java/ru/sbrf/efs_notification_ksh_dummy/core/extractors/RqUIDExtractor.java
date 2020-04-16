package ru.sbrf.efs_notification_ksh_dummy.core.extractors;

import org.apache.commons.lang3.StringUtils;

public class RqUIDExtractor implements IExtractor<String, String> {
    //todo написать более оптимальный способ извлечения RqUID
    public String extract(String text) {
        return StringUtils.substringBetween(text, "RqUID>", "</");
    }
}
