import java.util.Arrays;
import java.util.Comparator;

/**
 * @author htdong
 */
public class Main {

    static class CompratorByFileName implements Comparator<String> {
        public int compare(String f1, String f2) {
            long diff = f2.compareTo(f1);
            if (diff > 0) {
                return 1;
            } else if (diff < 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        String[] s = new String[] { "a", "b", "ca", "c", "d" };
        Arrays.sort(s, new CompratorByFileName());
        for (String i : s) {
            System.out.println(i);
        }
    }
}