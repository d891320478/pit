
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(URLEncoder.encode("+", "utf-8"));
        System.out.println(URLDecoder.decode("%2F%20", "utf-8"));
    }
}