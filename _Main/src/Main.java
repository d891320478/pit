import java.net.URLEncoder;

public class Main {

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis() - 1000 * 60 * 5);
        System.out.println(URLEncoder.encode("docker ps -a"));
    }
}