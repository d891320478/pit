import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;

/**
 * @author htdong
 */

public class Main {

    public static void main(String[] args) throws IOException {
        URL url = new URL(
                "http://10.0.19.105:8082/repository/basic/basic/server/dev-ops/202106291512/dev-ops-202106291512.jar");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        String basicAuth = "Basic " + Base64.encodeBase64String("deploy:deploy".getBytes());
        connection.setRequestProperty("Authorization", basicAuth);
        connection.setRequestProperty("Accept", "text/html");
        connection.setRequestProperty("Accept-Language", "en-US");
        connection.setRequestMethod("GET");
        connection.setDoInput(true);
        connection.setDoOutput(true);
        String[] paths = url.getFile().split("/");
        String fileName = paths[paths.length - 1];
        File f = new File("E:/" + fileName);
        try (BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
                FileOutputStream fis = new FileOutputStream(f);) {
            byte[] buffer = new byte[1024];
            int count = 0;
            while ((count = bis.read(buffer, 0, 1024)) != -1) {
                fis.write(buffer, 0, count);
            }
        }
        System.out.println("finish");
    }
}