package com.htdong.test.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author htdong
 * @date 2018年9月7日 下午2:37:55
 */

public class GsonTest {

    public static void main(String[] args) {
        String json1 = "[{\"id\":1,\"name\":\"eric\"},{\"id\":2,\"name\":\"eric2\"}]";
        String json2 = "[{\"id\":2,\"name\":\"eric2\"},{\"name\":\"eric\",\"id\":1}]";
        JsonParser parser = new JsonParser();
        JsonElement obj = parser.parse(json1);
        JsonParser parser1 = new JsonParser();
        JsonElement obj1 = parser1.parse(json2);
        System.out.println(obj.equals(obj1));
        Gson gson = new GsonBuilder().create(); 
        JsonElement e1 = gson.toJsonTree(json1);
        JsonElement e2 = gson.toJsonTree(json2);  
        System.out.println(e1.equals(e2));
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
