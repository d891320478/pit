package com.htdong.string;

import java.util.regex.Pattern;

/**
 * 
 * @author htdong
 */
public class StringTest {
	public static void main(String[] args) {
		String s = "^(?![\\s\\S]*[\\|\\'])[\\s\\S]*$";
		String t = "";
		System.out.println(Pattern.matches(s, t));
	}
}