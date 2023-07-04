import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner in = new Scanner(new File("/Users/dht31261/Desktop/1.txt"))) {
            TreeSet<String> set = new TreeSet<>();
            while (in.hasNextLine()) {
                set.add(in.nextLine());
            }
            for (String git : set) {
                System.out.println(git);
            }
        }
    }
}