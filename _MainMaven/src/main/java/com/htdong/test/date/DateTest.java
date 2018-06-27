package com.htdong.test.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import com.shinemo.client.util.DateUtils;

/**
 * 
 * @author htdong
 */
public class DateTest {
    public static void main(String[] args) {
        System.out.println(DateUtils.getDayBegin(System.currentTimeMillis()));
        System.out.println(DateUtils.getDayEnd(new Date().getTime()) + 1);
    }
}