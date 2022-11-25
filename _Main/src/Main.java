import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        String s = URLEncoder.encode("mysqld");
        System.out.println(URLDecoder.decode(s));
        System.out.println(URLEncoder.encode("curl \"http://172.168.214.45:9090/api/v1/query?query=" + s + "\""));
        String b =
            "eyJiX25hbWUiOiLokaPmtanlpKkiLCJiX21vYmlsZSI6IjE1OTU3MTkzMTIwIiwiYl9kZXYiOiJ0cnVlIiwiZXhwIjoxNjY5MjA0MTExLCJiX3VzZXJJZCI6IjIwMiJ9";
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date(1669276536878L));
    }
}