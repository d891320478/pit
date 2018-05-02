import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author htdong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Set<String> set = new TreeSet<>();
        set.add("1");
        set.remove("2");
        System.out.println(set.size());
    }

}