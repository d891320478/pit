import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        File f = new File("/Users/dht31261/Desktop/123.txt");
        try (FileWriter write = new FileWriter(f)) {
            for (;;) {
                write.write("11234567890987654321234567890987654321");
                write.flush();
            }
        } catch (IOException e) {
        }
    }
}
