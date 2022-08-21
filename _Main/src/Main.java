import java.io.IOException;
import java.net.URL;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

public class Main {

    public static void main(String[] args) throws IOException {
        String urlStr = "https://taobao.com";
        URL url = new URL(urlStr);
        HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
        connection.connect();

        for (Certificate certificate : connection.getServerCertificates()) {
            X509Certificate x509Certificate = (X509Certificate)certificate;
            Date stopDate = x509Certificate.getNotAfter();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(format.format(stopDate));
            break;
        }
    }
}