import java.util.Scanner;

/**
 * @author htdong
 */
public class Main {

    public static void main(String[] args) {
        String s = "rm -rf %s && git clone ssh://git@git.shinemo.com:7999/zqzt/%s.git\n";
        try (Scanner in = new Scanner(System.in)) {
            for (;;) {
                String c = in.next();
                String[] b = c.split(" ");
                for (String a : b) {
                    if (a == null) {
                        continue;
                    }
                    System.out.printf(s, a, a);
                }
            }
        }

    }
}