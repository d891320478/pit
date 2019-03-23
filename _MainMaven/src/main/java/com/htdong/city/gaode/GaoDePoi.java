package com.htdong.city.gaode;

import java.util.HashMap;
import java.util.Map;

import com.shinemo.client.http.HttpConnectionUtil;

/**
 *
 * @author htdong
 * @date 2018年7月26日 下午5:15:40
 */

public class GaoDePoi {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("types", null);
        map.put("city", null);
        map.put("children", 1);
        map.put("offset", null);
        map.put("page", null);
        map.put("extensions", "all");
        String s = HttpConnectionUtil.httpGet(
                "https://restapi.amap.com/v3/place/text?key=27ce3284b1b642a12c28df9c438b8531", map, String.class);
        System.out.println(s);
    }
}
