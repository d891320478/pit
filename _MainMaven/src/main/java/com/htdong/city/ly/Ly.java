package com.htdong.city.ly;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author htdong
 */
public class Ly {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("D:\\1.txt"));
		BufferedWriter out = new BufferedWriter(new FileWriter(new File("D:\\2.txt")));
		while (in.hasNextLine()) {
			String s = in.nextLine();
			if (!StringUtils.isBlank(s)) {
				out.write("##" + s + "\r\n");
			}
		}
		out.flush();
		out.close();
		in.close();
	}
}
