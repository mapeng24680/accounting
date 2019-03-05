package com.student.accounting.utils;/**
 * Created by dell on 2019/3/5.
 */

import org.springframework.util.Assert;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @description: 时间工具类
 * @author: mapeng
 * @create: 2019-03-05 13:12
 **/
public class DateUtils {
    public static String convertTimeToString(Long time) {
        Assert.notNull(time, "time is null");
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault()));
    }

}
