import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author htdong
 */

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("E:\\poi.txt"));
        Map<String, List<String>> map = new HashMap<>();
        int line = 0;
        while (in.hasNextLine()) {
            ++line;
            System.out.println(line);
            String s = in.nextLine();
            if(s.length() < 2) {
                continue;
            }
            String[] ss = s.split("#");
            if(ss[4].equals("6")) {
                continue;
            }
            String key = ss[3] + "#" + ss[4] + "#" + ss[9];
            List<String> val = map.get(key);
            if (val == null) {
                val = new LinkedList<>();
                map.put(key, val);
            }
            val.add(s);
        }
        BufferedWriter out = new BufferedWriter(new FileWriter(new File("E:\\4.txt")));
        for (Map.Entry<String, List<String>> iter : map.entrySet()) {
            if (iter.getValue().size() > 1) {
                boolean flag = false;
                for (String j : iter.getValue()) {
                    if(!flag) {
                        flag = true;
                    } else {
                        out.write(j.split("#")[11] + "\n");
                    }
                }
            }
        }
        out.flush();
        out.close();
        in.close();
    }

}