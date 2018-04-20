package com.htdong.city.standard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author htdong
 */
public class Standard {

	public static final String SPLIT = "##";

	private static Scanner in1;
	private static Scanner in2;
	private static BufferedWriter out2;
	private static BufferedWriter out3;
	private static Map<String, String> mmp = new HashMap<>();

	static {
		mmp.put("110103", "110101");
		mmp.put("110104", "110102");
		mmp.put("110228", "110118");
		mmp.put("110229", "110119");
		mmp.put("120107", "120116");
		mmp.put("120108", "120116");
		mmp.put("120109", "120116");
		mmp.put("120221", "120117");
		mmp.put("120223", "120118");
		mmp.put("120225", "120119");
		mmp.put("130103", "130102,130104");
		mmp.put("130124", "130111");
		mmp.put("130182", "130109");
		mmp.put("130185", "130110");
		mmp.put("130230", "130209");
		mmp.put("130323", "130306");
		mmp.put("130421", "130402,130403");
		mmp.put("130428", "130407");
		mmp.put("130429", "130408");
		mmp.put("130603", "130606");
		mmp.put("130604", "130606");
		mmp.put("130621", "130607");
		mmp.put("130622", "130608");
		mmp.put("130625", "130609");
		mmp.put("130721", "130705");
		mmp.put("130729", "130708");
		mmp.put("130733", "130709");
		mmp.put("130823", "130881");
		mmp.put("131181", "131103");
		mmp.put("210122", "210115");
		mmp.put("210282", "210214");
		mmp.put("211121", "211104");
		mmp.put("220181", "220113");
		mmp.put("220604", "220605");
		mmp.put("220724", "220781");
		mmp.put("230182", "230113");
		mmp.put("230833", "230883");
		mmp.put("231024", "231086");
		mmp.put("232702", "232721");
		mmp.put("232703", "232721");
		mmp.put("232704", "232721");
		mmp.put("310103", "310101");
		mmp.put("310108", "310106");
		mmp.put("310119", "310115");
		mmp.put("211121", "211104");
		mmp.put("310230", "310151");
		mmp.put("320103", "320104");
		mmp.put("320107", "320302");
		mmp.put("320124", "320117");
		mmp.put("320125", "320118");
		mmp.put("320202", "320213");
		mmp.put("320203", "320213");
		mmp.put("320204", "320213");
		mmp.put("320304", "320311,320302,320312");
		mmp.put("320125", "320118");
		mmp.put("320323", "320312");
		mmp.put("320405", "320412");
		mmp.put("320482", "320413");
		mmp.put("320502", "320508");
		mmp.put("320503", "320508");
		mmp.put("320504", "320508");
		mmp.put("320584", "320509");
		mmp.put("320683", "320612");
		mmp.put("320705", "320706");
		mmp.put("320721", "320707");
		mmp.put("320802", "320812");
		mmp.put("320811", "320812");
		mmp.put("320829", "320813");
		mmp.put("320982", "320904");
		mmp.put("321011", "321003");
		mmp.put("321088", "321012");
		mmp.put("321284", "321204");
		mmp.put("330183", "330111");
		mmp.put("330204", "330212");
		mmp.put("330283", "330213");
		mmp.put("330322", "330305");
		mmp.put("330621", "330603");
		mmp.put("330682", "330604");
		mmp.put("331021", "331083");
		mmp.put("340502", "340503");
		mmp.put("340702", "340705");
		mmp.put("340703", "340705");
		mmp.put("340721", "340706");
		mmp.put("340823", "340722");
		mmp.put("341402", "340181");
		mmp.put("341421", "340124");
		mmp.put("341422", "340225");
		mmp.put("341400", "340100,340200,340500");
		mmp.put("341423", "340522");
		mmp.put("341424", "340523");
		mmp.put("341521", "340422");
		mmp.put("350784", "350703");
		mmp.put("350822", "350803");
		mmp.put("360122", "360112");
		mmp.put("360427", "360483");
		mmp.put("360721", "360704");
		mmp.put("360782", "360703");
		mmp.put("361029", "361003");
		mmp.put("361122", "361103");
		mmp.put("370181", "370114");
		mmp.put("370205", "370203");
		mmp.put("370284", "370211");
		mmp.put("370521", "370505");
		mmp.put("370802", "370811");
		mmp.put("370882", "370812");
		mmp.put("370903", "370911");
		mmp.put("371081", "371003");
		mmp.put("371421", "371403");
		mmp.put("371624", "371603");
		mmp.put("371727", "371703");
		mmp.put("410211", "410202");
		mmp.put("410224", "410212");
		mmp.put("410307", "410311");
		mmp.put("410881", "419001");
		mmp.put("411023", "411003");
		mmp.put("411222", "411203");
		mmp.put("420321", "420304");
		mmp.put("421302", "421303");
		mmp.put("430122", "430112");
		mmp.put("440116", "440112");
		mmp.put("440183", "440118");
		mmp.put("440184", "440117");
		mmp.put("440903", "440904");
		mmp.put("440923", "440904");
		mmp.put("441283", "441204");
		mmp.put("441421", "441403");
		mmp.put("441723", "441704");
		mmp.put("441827", "441803");
		mmp.put("445121", "445103");
		mmp.put("445221", "445203");
		mmp.put("445323", "445303");
		mmp.put("450122", "450110");
		mmp.put("450221", "450206");
		mmp.put("450322", "450312");
		mmp.put("450404", "450403");
		mmp.put("451025", "451081");
		mmp.put("451281", "451203");
		mmp.put("469003", "460400");
		mmp.put("469031", "469026");
		mmp.put("469033", "469027");
		mmp.put("469034", "469028");
		mmp.put("469035", "469029");
		mmp.put("469036", "469030");
		mmp.put("469037", "460321");
		mmp.put("469038", "460322");
		mmp.put("469039", "460323");
		mmp.put("500222", "500110");
		mmp.put("500223", "500152");
		mmp.put("500224", "500151");
		mmp.put("500225", "500111");
		mmp.put("500226", "500153");
		mmp.put("500227", "500120");
		mmp.put("500228", "500155");
		mmp.put("500232", "500156");
		mmp.put("500234", "500154");
		mmp.put("510122", "510116");
		mmp.put("510124", "510117");
		mmp.put("510724", "510705");
		mmp.put("511028", "511083");
		mmp.put("511422", "511403");
		mmp.put("511522", "511503");
		mmp.put("511721", "511703");
		mmp.put("511821", "511803");
		mmp.put("512081", "510185");
		mmp.put("513229", "513201");
		mmp.put("513321", "513301");
		mmp.put("520114", "520111");
		mmp.put("520222", "520281");
		mmp.put("520321", "520300");
		mmp.put("520421", "520403");
		mmp.put("522200", "520600");
		mmp.put("522201", "520602");
		mmp.put("522222", "520621");
		mmp.put("522223", "520622");
		mmp.put("522224", "520623");
		mmp.put("522225", "520624");
		mmp.put("522226", "520625");
		mmp.put("522227", "520626");
		mmp.put("522228", "520627");
		mmp.put("522229", "520628");
		mmp.put("522230", "520603");
		mmp.put("522400", "520500");
		mmp.put("522401", "520502");
		mmp.put("522422", "520521");
		mmp.put("522423", "520522");
		mmp.put("522424", "520523");
		mmp.put("522425", "520524");
		mmp.put("522426", "520525");
		mmp.put("522427", "520526");
		mmp.put("522428", "520527");
		mmp.put("530121", "530114");
		mmp.put("530122", "530115");
		mmp.put("530328", "530303");
		mmp.put("530421", "530403");
		mmp.put("530522", "530581");
		mmp.put("532522", "532503");
		mmp.put("532526", "532504");
		mmp.put("532621", "532601");
		mmp.put("533321", "533301");
		mmp.put("533421", "533401");
		mmp.put("540125", "540103");
		mmp.put("542100", "540300");
		mmp.put("542121", "540302");
		mmp.put("542122", "540321");
		mmp.put("542123", "540322");
		mmp.put("542124", "540323");
		mmp.put("542125", "540324");
		mmp.put("542126", "540325");
		mmp.put("542127", "540326");
		mmp.put("542128", "540327");
		mmp.put("542129", "540328");
		mmp.put("542132", "540329");
		mmp.put("542133", "540330");
		mmp.put("542200", "540500");
		mmp.put("542221", "540502");
		mmp.put("542222", "540521");
		mmp.put("542223", "540522");
		mmp.put("542224", "540523");
		mmp.put("542225", "540524");
		mmp.put("542226", "540525");
		mmp.put("542227", "540526");
		mmp.put("542228", "540527");
		mmp.put("542229", "540528");
		mmp.put("542229", "540528");
		mmp.put("542231", "540529");
		mmp.put("542232", "540530");
		mmp.put("542233", "540531");
		mmp.put("542300", "540200");
		mmp.put("542301", "540202");
		mmp.put("542322", "540221");
		mmp.put("542323", "540222");
		mmp.put("542324", "540223");
		mmp.put("542325", "540224");
		mmp.put("542326", "540225");
		mmp.put("542327", "540226");
		mmp.put("542328", "540227");
		mmp.put("542329", "540228");
		mmp.put("542330", "540229");
		mmp.put("542331", "540230");
		mmp.put("542332", "540231");
		mmp.put("542333", "540232");
		mmp.put("542334", "540233");
		mmp.put("542335", "540234");
		mmp.put("542336", "540235");
		mmp.put("542337", "540236");
		mmp.put("542338", "540237");
		mmp.put("542600", "540400");
		mmp.put("542621", "540402");
		mmp.put("542622", "540421");
		mmp.put("542623", "540422");
		mmp.put("542624", "540423");
		mmp.put("542625", "540424");
		mmp.put("542626", "540425");
		mmp.put("542627", "540426");
		mmp.put("610125", "610118");
		mmp.put("610126", "610117");
		mmp.put("610521", "610503");
		mmp.put("610624", "610603");
		mmp.put("610821", "610881");
		mmp.put("610823", "610803");
		mmp.put("632100", "630200");
		mmp.put("632121", "630203");
		mmp.put("632122", "630222");
		mmp.put("632123", "630202");
		mmp.put("632126", "630223");
		mmp.put("632127", "630224");
		mmp.put("632128", "630225");
		mmp.put("632721", "632701");
		mmp.put("650108", "650109");
		mmp.put("652100", "650400");
		mmp.put("652101", "650402");
		mmp.put("652122", "650421");
		mmp.put("652123", "650422");
		mmp.put("652200", "650500");
		mmp.put("652201", "650502");
		mmp.put("652222", "650521");
		mmp.put("652223", "650522");
		mmp.put("652303", "650109");
	}

	public static void main(String[] args) throws IOException {
		Map<String, String> mm = new HashMap<>(8);
		mm.put("469025", "469021");
		mm.put("469026", "469022");
		mm.put("469027", "469023");
		mm.put("469028", "469024");
		mm.put("469030", "469025");
		File f1 = new File("D:\\1.txt");
		File f2 = new File("D:\\2.txt");
		File f4 = new File("D:\\4.txt");
		File f5 = new File("D:\\9.txt");
		in1 = new Scanner(f1);
		in2 = new Scanner(f2);
		out2 = new BufferedWriter(new FileWriter(f4));
		out3 = new BufferedWriter(new FileWriter(f5));
		Map<String, String> m1 = new LinkedHashMap<>();
		while (in1.hasNextLine()) {
			String s = in1.nextLine();
			m1.put(s.split(SPLIT)[0], s);
		}
		int cnt = 0;
		int cnt2 = 0;
		while (in2.hasNextLine()) {
			++cnt;
			String s = in2.nextLine();
			String[] ss = s.split(SPLIT);
			if (m1.containsKey(ss[0])) {
				String m1key = null;
				if (mm.containsKey(ss[0])) {
					m1key = mm.get(ss[0]);
				} else {
					m1key = ss[0];
				}
				if (ss.length > 2) {
					out3.write(m1key + SPLIT + ss[0] + SPLIT + ss[2] + "\r\n");
				} else {
					out3.write(m1key + SPLIT + ss[0] + SPLIT + ss[1] + "\r\n");
				}
			} else if (mmp.containsKey(ss[0])) {
				String[] v = mmp.get(ss[0]).split(",");
				for (String iter : v) {
					if (!m1.containsKey(iter)) {
						++cnt2;
						out2.write(s + "\r\n");
					} else {
						if (ss.length > 2) {
							out3.write(iter + SPLIT + ss[0] + SPLIT + ss[2] + "\r\n");
						} else {
							out3.write(iter + SPLIT + ss[0] + SPLIT + ss[1] + "\r\n");
						}
					}
				}
			} else {
				++cnt2;
				out2.write(s + "\r\n");
			}
		}
		out2.flush();
		out2.close();
		out3.flush();
		out3.close();
		System.out.println(cnt + " " + cnt2);
	}
}