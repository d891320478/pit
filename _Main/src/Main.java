import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author htdong
 */

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("E:\\7.txt"));
        Set<String> set = new TreeSet<>();
        while (in.hasNextLine()) {
            set.add(in.nextLine());
        }
        System.out.println(set.size());
        for (String i : set) {
            System.out.print("\'"+i+"\',");
        }
        in.close();
    }

}