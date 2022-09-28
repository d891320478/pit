
import java.io.IOException;
import java.net.URLEncoder;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(URLEncoder.encode("docker ps -a"));
    }
}