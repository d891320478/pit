import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File("/Users/dht31261/Desktop/1.txt"))) {
            int cnt = 0;
            while (in.hasNextLine()) {
                String s = in.nextLine();
                if (s.contains("aom time = ")) {
                    cnt += Integer.parseInt(s.substring(s.lastIndexOf("aom time = ") + "aom time = ".length()));
                }
            }
            System.out.println(cnt);
        }
    }
}