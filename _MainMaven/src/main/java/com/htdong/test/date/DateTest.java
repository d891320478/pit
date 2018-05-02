package com.htdong.test.date;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 * 
 * @author htdong
 */
public class DateTest {
	public static void main(String[] args) {
	    LocalDate now = LocalDate.now();
	    ZoneId zoneId = ZoneId.systemDefault();
	    Date checkOut = new Date(now.plus(Period.ofDays(90)).atStartOfDay(zoneId).toEpochSecond() * 1000);
		System.out.println(checkOut);
	}
}