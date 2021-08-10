import java.io.IOException;

import org.apache.commons.lang3.ArrayUtils;

/**
 * @author htdong
 */

public class Main {

    public static void main(String[] args) throws IOException {
        String[] a = new String[] { "a", "b" };
        String[] b = new String[] { "a", "b" };
        System.out.println(ArrayUtils.addAll(a, b).length);
    }
}