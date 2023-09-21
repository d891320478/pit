import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(URLEncoder.encode("build/178_240", Charset.defaultCharset()));
    }
}