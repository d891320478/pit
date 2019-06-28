import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author htdong
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Long x = Long.valueOf(123213123);
        Long y = Long.valueOf(123213123);
        System.out.println(x != y);
    }
}