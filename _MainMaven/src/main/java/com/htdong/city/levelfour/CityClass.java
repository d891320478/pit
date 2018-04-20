package com.htdong.city.levelfour;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author htdong
 * @date 2018年4月18日 上午10:27:49
 */

@Setter
@Getter
public class CityClass {
    private String code;
    private String name;
    private List<CityClass> children;
}
