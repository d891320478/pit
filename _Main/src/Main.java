import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author htdong
 */

public class Main {

    public static void main(String[] args) throws IOException {
        FileWriter outMonth = new FileWriter(new File("E:/login_month.txt"), true);
        FileWriter outWeek = new FileWriter(new File("E:/login_week.txt"), true);
        FileWriter outDay = new FileWriter(new File("E:/login_day.txt"), true);
        File[] file = new File[] { new File("E:/infolog-cmmc1"), new File("E:/infolog-cmmc2") };
        for (File iter : file) {
            File[] ff = iter.listFiles();
            for (File jter : ff) {
                Scanner in = new Scanner(jter);
                while (in.hasNextLine()) {
                    String s = in.nextLine();
                    if (!s.contains("[handleUserInfoResult] 获取解密后的用户信息")) {
                        continue;
                    }
                    System.out.println(s);
                    String date = s.substring(0, 19);
                    String mobile = null;
                    if (s.contains("\"phone\":\"")) {
                        mobile = s.substring(s.indexOf("\"phone\":\"") + 9, s.indexOf("\"phone\":\"") + 20);
                    }
                    String city = null;
                    if (s.contains("\"city\":\"")) {
                        city = s.substring(s.indexOf("\"city\":\"") + 8, s.indexOf("\"city\":\"") + 28);
                        city = city.substring(0, city.indexOf("\""));
                    } else if (s.contains("\"cityName\":\"")) {
                        city = s.substring(s.indexOf("\"cityName\":\"") + 12, s.indexOf("\"cityName\":\"") + 32);
                        city = city.substring(0, city.indexOf("\""));
                    }
                    String name = null;
                    if (s.contains("\"name\":\"")) {
                        name = s.substring(s.indexOf("\"name\":\"") + 8, s.indexOf("\"name\":\"") + 18);
                        name = name.substring(0, name.indexOf("\""));
                    }
                    if(mobile == null && name == null && city == null) {
                        continue;
                    }
                    if (s.startsWith("2021-01-06")) {
                        outDay.write(date + " " + city + " " + mobile + " " + name + "\r\n");
                        outWeek.write(date + " " + city + " " + mobile + " " + name + "\r\n");
                    }
                    if (s.startsWith("2021-01-04") || s.startsWith("2021-01-05")) {
                        outWeek.write(date + " " + city + " " + mobile + " " + name + "\r\n");
                    }
                    outMonth.write(date + " " + city + " " + mobile + " " + name + "\r\n");
                }
                in.close();
            }
        }
        outDay.flush();
        outDay.close();
        outWeek.flush();
        outWeek.close();
        outMonth.flush();
        outMonth.close();
    }
}