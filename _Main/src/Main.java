import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author htdong
 */

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("E:\\5.txt"));
        BufferedWriter out = new BufferedWriter(new FileWriter(new File("E:\\6.txt")));
        List<String> list = new ArrayList<>();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            list.add(s);
        }
        list.sort((o1, o2) -> {
            String[] s1 = o1.split(",");
            String[] s2 = o2.split(",");
            return s1[1].compareTo(s2[1]);
        });
        for (String s : list) {
            out.write(s + "\n");
        }
        out.flush();
        out.close();
        in.close();
    }

}