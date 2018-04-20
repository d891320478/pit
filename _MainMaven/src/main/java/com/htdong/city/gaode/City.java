package com.htdong.city.gaode;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author htdong
 */
@Setter
@Getter
public class City {
	private String adcode;
	private String name;
	private String center;
	private String level;
	private List<City> districts;
}
