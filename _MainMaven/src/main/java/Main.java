import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File tmp = File.createTempFile("aaa", ".txt");
        System.out.println(tmp.getAbsolutePath());
        tmp.delete();
    }
}