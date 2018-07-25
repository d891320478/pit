import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author htdong
 */

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("E:\\1.txt"));
        BufferedWriter out = new BufferedWriter(new FileWriter(new File("E:\\2.txt")));
        Map<String, String> map = new HashMap<>();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] ss = s.split(",");
            map.put(ss[0], ss[1]);
        }
        for (Map.Entry<String, String> iter : map.entrySet()) {
            out.write(iter.getKey() + "," + iter.getValue() + "\n");
        }
        out.close();
        in.close();
    }

}