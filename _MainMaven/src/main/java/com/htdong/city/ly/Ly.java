package com.htdong.city.ly;

import java.io.IOException;

import org.apache.commons.lang.RandomStringUtils;

/**
 * 
 * @author htdong
 */
public class Ly {

    private static String PASSWORD_STR_SET = "ABCDEFGHJKLMNPQRSTUVWXYZ123456789";

    public static void main(String[] args) throws IOException {
        System.out.println(
                RandomStringUtils.random(8, PASSWORD_STR_SET.toCharArray()));
    }
}
