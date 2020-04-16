package ru.sbrf.efs_notification_ksh_dummy.core.format;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateFormat {
    // todo исправить на норм решение
    public static String format(String format){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(calendar.getTime());
    }
}
