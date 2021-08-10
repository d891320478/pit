import java.util.Arrays;
import java.util.List;

/**
 * @author htdong
 */

public class Main {

    public static void main(String[] args) {
        List<String> l = Arrays.asList("1", "2");
        System.out.println(l.toArray(new String[0]).length);
    }
}