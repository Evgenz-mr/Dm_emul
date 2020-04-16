package ru.sbrf.efs_notification_ksh_dummy.core.influxdb;


import lombok.Data;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;
import ru.sbrf.efs_notification_ksh_dummy.core.map.IMapper;

@Data
public class InfluxDBSender<T> {

    InfluxDB influxDB;
    IMapper<T, Point> toPointMapper;
    String database;
    String retentionPolicy;

    public void send(T entry) {
        Point point =  toPointMapper.map(entry);
        influxDB.write(database, retentionPolicy, point);
    }
}
