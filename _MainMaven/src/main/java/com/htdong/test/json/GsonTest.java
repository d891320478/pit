package com.htdong.test.json;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author htdong
 * @date 2018年9月7日 下午2:37:55
 */

public class GsonTest {

    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        String c = "[{\"roomName\":\"房间\",\"roomDesc\":\"房间\",\"photoURL\":[\"http://dimg04.c-ctrip.com/images/200u0b0000005y57nAE8E_R_550_412.jpg\",\"http://dimg04.c-ctrip.com/images/200c0b0000005y4sq8211_R_550_412.jpg\",\"http://dimg04.c-ctrip.com/images/200v0b0000005scyv82F2_R_550_412.jpg\",\"http://dimg04.c-ctrip.com/images/t1/hotel/458/080/846/d39aff301adb4bbfa9d82b182afcebb9_R_550_412.jpg\",\"http://dimg04.c-ctrip.com/images/200u0b0000005y57mDEEB_R_550_412.jpg\",\"http://dimg04.c-ctrip.com/images/2007050000000s3gf4FE5_R_550_412.jpg\"]}]";
        String d = "[{\"roomName\":\"房间\",\"roomDesc\":\"房间\",\"photoURL\":[\"http://dimg04.c-ctrip.com/images/200u0b0000005y57nAE8E_R_550_412.jpg\",\"http://dimg04.c-ctrip.com/images/200c0b0000005y4sq8211_R_550_412.jpg\",\"http://dimg04.c-ctrip.com/images/200v0b0000005scyv82F2_R_550_412.jpg\",\"http://dimg04.c-ctrip.com/images/t1/hotel/458/080/846/d39aff301adb4bbfa9d82b182afcebb9_R_550_412.jpg\",\"http://dimg04.c-ctrip.com/images/200u0b0000005y57mDEEB_R_550_412.jpg\",\"http://dimg04.c-ctrip.com/images/2007050000000s3gf4FE5_R_550_412.jpg\"]}]___"
                .substring(0, c.length());
        System.out.println(c == d);
        System.out.println(c.equals(d));
        System.out.println(gson.toJsonTree(c).equals(gson.toJsonTree(d)));

    }
}

class Abc {
    private @Setter @Getter String test;
    private @Setter @Getter Integer a;

    public Abc(String test, Integer a) {
        this.test = test;
        this.a = a;
    }
}

class Def {
    private @Setter @Getter Integer a;
    private @Setter @Getter String test;

    public Def(Integer a, String test) {
        this.test = test;
        this.a = a;
    }
}
