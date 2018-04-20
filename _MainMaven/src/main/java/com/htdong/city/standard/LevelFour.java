package com.htdong.city.standard;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.htdong.city.levelfour.CityClass;

/**
 *
 * @author htdong
 * @date 2018年4月18日 上午10:37:36
 */

public class LevelFour {

    private static final TypeReference<List<CityClass>> typeToken = new TypeReference<List<CityClass>>() {
    };

    private static int cnt = 0;

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        File f1 = new File("E:\\github\\Administrative-divisions-of-China\\dist\\pcas-code.json");
        List<CityClass> list = new ObjectMapper().readValue(f1, typeToken);
        count(list);
        System.err.println(cnt);
    }

    private static void count(List<CityClass> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (CityClass iter : list) {
            if (iter.getCode().length() > 6) {
                ++cnt;
            }
            count(iter.getChildren());
        }
    }
}
