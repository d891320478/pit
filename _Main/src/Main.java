import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(URLEncoder.encode(
            Base64.getEncoder().encodeToString(
                "测试base64长度098765432345678976543456765，长度12342341234adggsdgerefarfafafafwqgrwgerahgerh".getBytes()),
            Charset.defaultCharset()));
        System.out.println(URLEncoder.encode(
            "wget -O baas-login.jar 'localhost:10004/repository/basic/basic/server/baas-login/7.7.14-noarch/baas-login-7.7.14-noarch-baseline_9f6f3bb.jar'",
            Charset.defaultCharset()));
        System.out.println(URLEncoder.encode("ls -lh", Charset.defaultCharset()));
        for (int i = 0; i < 10; ++i) {
            System.err.println(new Random().nextInt(2));
        }
    }
}