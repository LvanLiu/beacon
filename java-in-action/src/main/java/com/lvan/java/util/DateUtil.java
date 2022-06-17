package com.lvan.java.util;

import lombok.experimental.UtilityClass;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Qibin Liu
 * @date 2022-06-17 9:32
 */
@UtilityClass
public class DateUtil {

    /**
     * 缺少对 ThreadLocal 显示 remove, 可能会引发内存泄漏的问题
     */
    private static final ThreadLocal<SimpleDateFormat> local = new ThreadLocal<>();

    private static SimpleDateFormat getDateFormat() {
        SimpleDateFormat dateFormat = local.get();
        if (dateFormat == null) {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            local.set(dateFormat);
        }
        return dateFormat;
    }

    public static String format(Date date) {
        return getDateFormat().format(date);
    }

    public static Date parse(String dateStr) throws ParseException {
        return getDateFormat().parse(dateStr);
    }
}