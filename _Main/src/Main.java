import java.io.File;
import java.io.IOException;

/**
 * @author htdong
 */

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\static-world-logo.png");
        System.out.println(file.length());
    }
}