package com.htdong.test.json;

import java.io.IOException;
import java.util.Date;
import java.util.TreeMap;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.Getter;
import lombok.Setter;

/**
 * @author htdong
 * @date 2019年3月6日 上午10:38:45
 */

public class JacksonTest {

    public static final TypeReference<TreeMap<String, Object>> TREEMAP_TYPE = new TypeReference<TreeMap<String, Object>>() {
    };

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String json1 = "{\"test\":1541112900000}";
        TreeMap<String, Object> bodyMap;
        bodyMap = objectMapper.readValue(json1, TREEMAP_TYPE);
        System.out.println(Long.parseLong(bodyMap.get("test").toString()));
    }
}

class Aaa {
    private @Setter @Getter Date test;

    public Aaa() {
    }

    public Aaa(Date test) {
        this.test = test;
    }
}
