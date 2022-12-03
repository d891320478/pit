import java.net.URLEncoder;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(URLEncoder.encode("docker ps -a | grep configproxy"));
    }
}