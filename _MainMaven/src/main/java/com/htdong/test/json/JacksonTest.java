package com.htdong.test.json;

import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.shinemo.client.util.DateUtil;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author htdong
 * @date 2019年3月6日 上午10:38:45
 */

public class JacksonTest {
    
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String json1 = "{\"test\":1541112900000}";
        Aaa a = objectMapper.readValue(json1, Aaa.class);
        System.out.println(DateUtil.format(a.getTest()));
    }
}

class Aaa {
    private @Setter @Getter Date test;

    public Aaa() {
    }
    
    public Aaa(Date test) {
        test = test;
    }
}
