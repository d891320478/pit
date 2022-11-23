import java.net.URLEncoder;

public class Main {

    public static void main(String[] args) {
        System.out.println(URLEncoder.encode(
            "100 - (avg(rate(node_cpu_seconds_total{instance=\"10.185.56.176:9100\",mode=\"idle\"}[1m])) * 100)"));
    }
}