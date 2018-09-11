package com.htdong.test.date;

import java.util.Date;

import com.shinemo.client.util.DateUtils;

/**
 * 
 * @author htdong
 */
public class DateTest {
    public static void main(String[] args) {
        System.out.println(new Date(DateUtils.getDayBegin(DateUtils.plusDays(System.currentTimeMillis(), -7))));
    }
}