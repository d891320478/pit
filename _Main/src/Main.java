import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String p = "/Users/dht31261/gitsrc/middleware/dev-ops/pom.xml";
        File f = new File(p);
        System.out.println(f.getAbsolutePath());
    }
}