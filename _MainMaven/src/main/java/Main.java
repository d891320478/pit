import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.shinemo.client.http.HttpConnectionUtil;
import com.shinemo.client.http.HttpResult;

public class Main {

    public static void main(String[] args) throws Exception {
        File f = new File("E:/京东商品.txt");
        BufferedWriter out = new BufferedWriter(new FileWriter(f, true));
        int page = 1631;
        int maxPage = 100000;
        do {
            Map<String, Object> params = new HashMap<>();
            params.put("page", ++page);
            params.put("jd_stock_status", 1);
            Map<String, Object> map = new HashMap<>();
            map.put(":authority", "member.fxqifu.com");
            map.put(":method", "GET");
            map.put(":path", "/product_pick/jd_list");
            map.put(":scheme", "https");
            map.put("accept",
                    "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3");
            map.put("accept-encoding", "gzip, deflate, br");
            map.put("accept-language", "en-US,en;q=0.9,zh-CN;q=0.8,zh;q=0.7");
            map.put("cache-control", "max-age=0");
            map.put("cookie",
                    "SERVERID=99cd61de62e06be30ce368c12eb1e233|1561360891|1561360891; member_id=342; fxqf_sess=mr38q3nel4c5e298ecgb0v8bpf5lqp0u");
            map.put("upgrade-insecure-requests", "1");
            map.put("user-agent",
                    "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");

            HttpResult r = HttpConnectionUtil.get("https://member.fxqifu.com/product_pick/jd_list", params, map);
            System.out.println(r.getCode() + " " + page + " " + maxPage);
            String ret = r.getResult(String.class);
            Pattern p1 = Pattern.compile("\\d+");
            if (maxPage == 100000) {
                Pattern p = Pattern.compile("共\\d+页");
                Matcher m = p.matcher(ret);
                m.find();
                String b = m.group();
                Matcher m1 = p1.matcher(b);
                m1.find();
                maxPage = Integer.parseInt(m1.group());
            }
            Pattern tbody = Pattern.compile("<tbody[\\s\\S]*</tbody>");
            Matcher mt = tbody.matcher(ret);
            mt.find();
            String c = mt.group();
            Pattern td = Pattern.compile("</tr>[\\s]*<tr>");
            String[] cs = td.split(c);
            // System.out.println(cs[0]);
            // System.out.println(cs[1]);
            td = Pattern.compile("</td>[\\s]*<td>");
            for (int j = 0; j < cs.length; ++j) {
                String[] abc = td.split(cs[j]);
                out.write(getName(abc[1]).trim() + "^^");
                out.write(abc[2] + "^^");
                out.write(abc[3] + "^^");
                abc[4] = abc[4].trim();
                out.write(abc[4].substring(0, abc[4].length() - 1).trim() + "%^^");
                out.write(getNum(abc[5]) + "^^");
                out.write(abc[6]);
                out.newLine();
            }
        } while (page < maxPage);
        out.flush();
        out.close();
    }

    private static String getNum(String s) {
        Pattern td = Pattern.compile("<span[\\s\\S]*>[\\s\\S]*</span>");
        Matcher mt = td.matcher(s);
        mt.find();
        String a = mt.group();
        return a.substring(a.indexOf(">") + 1, a.indexOf("</span>"));
    }

    private static String getName(String s) {
        Pattern td = Pattern.compile("<span class=\"my-pro-name\">[\\s\\S]*</span>");
        Matcher mt = td.matcher(s);
        mt.find();
        String a = mt.group();
        return a.substring("<span class=\"my-pro-name\">".length(), a.indexOf("</span>"));
    }

}
