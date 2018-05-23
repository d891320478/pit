package com.htdong.test.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author htdong
 */
public class DateTest {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.FFFFFFFXXX");
        System.err.println(format.format(new Date()));
    }
}