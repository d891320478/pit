import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author htdong
 */

public class Main {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new LinkedList<>();
        list.add(0, 1);
        list.add(0, 2);
        list.add(0, 3);
        System.out.println(list);
    }
}