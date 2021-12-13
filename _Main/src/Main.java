import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author htdong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        try (Scanner in = new Scanner(new File("/Users/htdong/Desktop/gradle.txt"))) {
            while (in.hasNextLine()) {
                String[] s = in.nextLine().split(" ");
                Runtime runtime = Runtime.getRuntime();
                String cmd = "sh /tmp/git/git.sh " + s[2];
                runtime.exec(cmd);
                System.out.println(cmd);
            }
        }
    }
}