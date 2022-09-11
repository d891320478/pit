import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(URLEncoder.encode(
            "/home/admin/watchdog/bin/statics_rsync.sh /tmp/webapps/nanjing-yangzi-network-manage-web-0.0.2-noarch.tgz",
            Charset.defaultCharset()));
        System.out.println(URLEncoder.encode(
            "tar xvf /tmp/webapps/nanjing-yangzi-network-manage-web-0.0.2-noarch.tgz -C /", Charset.defaultCharset()));
        System.out.println(
            URLEncoder.encode("docker ps -a | grep configproxy", Charset.defaultCharset()));
    }
}