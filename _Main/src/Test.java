import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * @author htdong
 * @date 2018年12月28日 下午6:17:31
 */

public class Test {

    public static void main(String[] args) {
        for (int i = 0; i < 20; ++i) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    while (true) {
                        try {
                            URL url = new URL("http://localhost:8080/buycenter/test/test");
                            URLConnection con = url.openConnection();
                            con.connect();
                            try (Scanner in = new Scanner(con.getInputStream())) {
                                if (in.hasNextLine()) {
                                    System.out.println(Thread.currentThread().getName() + " " + in.nextLine());
                                }
                            }
                        } catch (IOException e) {
                        }
                    }

                }
            }).start();
        }
    }
}