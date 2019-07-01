import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author htdong
 */

public class Main {
    public static void main(String[] args) throws IOException {
        TreeMap<String,String> map = new TreeMap<>();
        map.put("2", "2");
        map.put("1", "1");
        map.put("3", "3");
        System.out.println(new ArrayList<>(map.values()));
    }
}