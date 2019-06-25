import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author htdong
 */

public class Main {
    public static void main(String[] args) throws IOException {
        Pattern p = Pattern.compile("共\\d+页");
        Pattern p1 = Pattern.compile("\\d+");
        Matcher m = p.matcher("共18页");
        m.find();
        String b = m.group();
        Matcher m1 = p1.matcher(b);
        m1.find();
        int a = Integer.parseInt(m1.group());
        System.out.println(a);
    }
}