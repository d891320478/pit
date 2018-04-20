package com.htdong.city.huazhu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author htdong
 */
public class HuaZhu {
	private static Scanner in;
	private static BufferedWriter out;
	public static final String SPLIT = "##";

	public static void main(String[] args) throws IOException {
		File f1 = new File("D:\\1.txt");
		File f2 = new File("D:\\2.txt");
		out = new BufferedWriter(new FileWriter(f2));
		in = new Scanner(f1);
		while (in.hasNextLine()) {
			String s = in.nextLine();
			String[] ss = s.split(",");
			StringBuilder sb = new StringBuilder();
			sb.append(ss[0].trim()).append(SPLIT).append(ss[1].trim());
			if (ss.length > 2) {
				sb.append(SPLIT).append(ss[2].trim());
			}
			if (ss.length > 3) {
				sb.append(ss[3].trim());
			}
			sb.append("\r\n");
			out.write(sb.toString());
		}
		out.flush();
		out.close();
	}
}