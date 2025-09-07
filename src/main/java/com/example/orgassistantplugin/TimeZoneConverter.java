package com.example.orgassistantplugin;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneConverter {

    public static String convertTimeZone(String time, String sourceTimeZone, String targetTimeZone) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(time, formatter);
        ZonedDateTime sourceZonedDateTime = localDateTime.atZone(ZoneId.of(sourceTimeZone));
        ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(ZoneId.of(targetTimeZone));
        return targetZonedDateTime.format(formatter);
    }
}
