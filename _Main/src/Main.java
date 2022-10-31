import java.net.URLEncoder;
import java.util.Base64;

public class Main {

    public static void main(String[] args) {
        System.out.println(URLEncoder.encode("domain_certificate_expired{url=\"https://saas.uban360.com\"}"));
        System.out.println(URLEncoder.encode("count_over_time(dockerCheckStatus{state!=\"running\"}[5m])"));
        System.out.println(new String(Base64.getEncoder().encodeToString(
            "3+~rx!aT0y>U;2M7[N;g}HAXdWvEH6$Lp@ }~\\dt=0BYp[BOgUBp$e'sCiYz,7#:C#q0X]3T#Z@qQ(o7>#S$M>%POhD'z|M&-*I_|zD8OU`M9ppV(Bupz52#^Li;\\!D@"
                .getBytes())));
    }
}