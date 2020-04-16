package ru.sbrf.efs_notification_ksh_dummy.core.map;

public interface IMapper<FROM, TO> {
    TO map(FROM value);
}
