package com.htdong.city.gaode;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.shinemo.client.http.HttpConnectionUtil;

/**
 * 
 * @author htdong
 */
public class GaoDe {
	private static BufferedWriter out;
	public static final String SPLIT = "##";

	public static void main(String[] args)
			throws JsonParseException, JsonMappingException, IOException, PinyinException {
		File f2 = new File("D:/out.txt");
		out = new BufferedWriter(new FileWriter(f2));
		String s = HttpConnectionUtil.httpGet(
				"http://restapi.amap.com/v3/config/district?subdistrict=3&key=7879c61f23bb5ab2dd050353c779898a",
				String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Result rlt = objectMapper.readValue(s.toString(), Result.class);
		write(rlt.getDistricts(), "", 0);
		out.flush();
		out.close();
	}

	private static void write(List<City> d, String p, int level) throws IOException, PinyinException {
		for (City i : d) {
			if ("street".equals(i.getLevel())) {
				continue;
			}
			StringBuilder sb = new StringBuilder();
			String[] ss = i.getCenter().split(",");
			sb.append(i.getAdcode()).append(SPLIT).append(i.getName()).append(SPLIT).append(p).append(SPLIT)
					.append(ss[0]).append(SPLIT).append(ss[1]).append(SPLIT).append(level).append(SPLIT)
					.append(PinyinHelper.convertToPinyinString(i.getName(), "", PinyinFormat.WITHOUT_TONE))
					.append(SPLIT).append(PinyinHelper.getShortPinyin(i.getName())).append("\r\n");
			out.write(sb.toString());
			if (StringUtils.isBlank(p)) {
				write(i.getDistricts(), i.getAdcode(), level + 1);
			} else {
				write(i.getDistricts(), p + "," + i.getAdcode(), level + 1);
			}
		}
	}
}
