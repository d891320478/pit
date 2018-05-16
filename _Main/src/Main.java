import java.io.IOException;

/**
 * 
 * @author htdong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String s = "bcdefbcd";
        s = s.replaceAll("cd", "aaaa");
        System.out.println(s);
    }

}