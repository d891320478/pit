import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println(URLEncoder.encode("ls -lh /data/configproxy"));
        System.out.println(URLEncoder.encode("mkdir -p /data/configproxy"));
        String s = "{\"command\":\"ps\", \"args\":[\"-ef\"]}";
        System.out.println(s);
        System.out.println(Base64.getEncoder().encodeToString(s.getBytes()));
        String t = "eyJjb21tYW5kIjogInNoIiwgImFyZ3MiOiBbIi9ob21lL2FkbWluL3dhdGNoZG9nL2Jpbi9jaGVja3NlLnNoIl19";
        System.out.println(new String(Base64.getDecoder().decode(t)));
        List<String> list = new ArrayList<>();
        list.add("1");
        System.out.println(list);
        System.out.println(list.subList(1, 1));
        System.out.println(LocalDateTime.ofInstant(new Date(1667917203000L).toInstant(), ZoneId.systemDefault()));
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt.plusMonths(-2));
    }
}