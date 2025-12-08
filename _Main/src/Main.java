import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<Integer, String> firstMap = new HashMap<>();
        Map<Integer, String> secondMap = new HashMap<>();
        Map<Integer, String> thirdMap = new HashMap<>();
        Map<Integer, Integer> secondParentMap = new HashMap<>();
        Map<Integer, Integer> thirdParentMap = new HashMap<>();
        Map<Integer, Integer> thirdWithCateMap = new HashMap<>();
        try (Scanner in = new Scanner(new File("/Users/dht31261/Downloads/行业映射.csv"));
            FileWriter fw = new FileWriter(new File("/Users/dht31261/Desktop/init.sql"))) {
            in.nextLine();
            while (in.hasNextLine()) {
                String[] s = in.nextLine().split(",");
                Integer first = Integer.parseInt(s[2]);
                Integer second = Integer.parseInt(s[4]);
                Integer third = Integer.parseInt(s[6]);
                Integer thirdCate = Integer.parseInt(s[7]);
                firstMap.put(first, s[1].trim());
                secondMap.put(second, s[3].trim());
                thirdMap.put(third, s[5].trim());
                secondParentMap.put(second, first);
                thirdParentMap.put(third, second);
                thirdWithCateMap.put(third, thirdCate);
            }

            for (Map.Entry<Integer, String> iter : firstMap.entrySet()) {
                String s = String.format(
                    "insert into chain_industry_category (gmt_create, gmt_modified, creator, modifier, category_code, category_name, category_level)"
                        + " values (now(), now(), 'SYSTEM', 'SYSTEM', %d, '%s', 1);\n",
                    iter.getKey(), iter.getValue());
                fw.write(s);
            }
            for (Map.Entry<Integer, String> iter : secondMap.entrySet()) {
                String s = String.format(
                    "insert into chain_industry_category (gmt_create, gmt_modified, creator, modifier, category_code, category_name, category_level, parent_code)"
                        + " values (now(), now(), 'SYSTEM', 'SYSTEM', %d, '%s', 2, %d);\n",
                    iter.getKey(), iter.getValue(), secondParentMap.get(iter.getKey()));
                fw.write(s);
            }
            for (Map.Entry<Integer, String> iter : thirdMap.entrySet()) {
                String s = String.format(
                    "insert into chain_industry_category (gmt_create, gmt_modified, creator, modifier, category_code, category_name, category_level, parent_code, category_third_code)"
                        + " values (now(), now(), 'SYSTEM', 'SYSTEM', %d, '%s', 3, %d, %d);\n",
                    iter.getKey(), iter.getValue(), thirdParentMap.get(iter.getKey()),
                    thirdWithCateMap.get(iter.getKey()));
                fw.write(s);
            }
            fw.flush();
        }
    }
}