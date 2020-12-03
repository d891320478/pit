package com.htdong.test.json;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

/**
 * @author htdong
 * @date 2019年3月6日 上午10:38:45
 */

public class JacksonTest {

    @Data
    public static class ForwardRequest {

        public static final String POST_METHOD = "post";
        public static final String GET_METHOD = "get";
        public static final String POST_FORM = "form";
        public static final String POST_JSON = "json";

        private String url;
        private Map<String, Object> header;
        private Map<String, Object> param;
        private String method;
        private String post;
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = "{\r\n" + "    \"method\": \"POST\",\r\n" + "    \"post\": \"json\",\r\n"
                + "    \"url\": \"http://10.183.80.193:8200/proxy?ProtocolType=002\",\r\n" + "    \"header\": {\r\n"
                + "        \"OIP-Sender\": \"21.maintenance-service\",\r\n"
                + "        \"OIP-Security\": \"da39a3ee5e6b4b0d3255bfef95601890afd80709\",\r\n"
                + "        \"OIP-ServCode\": \"21.maintenance-service.custportraitdaiwei\"\r\n" + "    },\r\n"
                + "    \"param\": {\r\n" + "        \"dw_phone\": \"18270361088\"\r\n" + "    }\r\n" + "}";
        ForwardRequest f = objectMapper.readValue(s, ForwardRequest.class);
        System.out.println(f);
    }
}