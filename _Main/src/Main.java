import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author htdong
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File("/Users/htdong/Desktop/1.csv"))) {
            int port = 11001;
            while (in.hasNextLine()) {
                String[] a = in.nextLine().split("\\|");
                a[2] = getPort(a[2]);
                System.out.println("update machine set proxy_ip = '192.168.47.60:" + port + "' where ip = '" + a[0]
                        + ":" + a[2] + "' and site_id = 1;");
                ++port;
            }
        }
    }

    public static String getPort(String a) {
        return Integer.parseInt(a.substring(6, a.indexOf("']"))) + "";
    }
}