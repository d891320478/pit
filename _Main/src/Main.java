
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String s = "1.1,2.2";
        System.out.println(s.replaceAll(",", "|"));
        System.out.println(System.currentTimeMillis());
    }
}