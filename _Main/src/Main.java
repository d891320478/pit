import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author htdong
 */
public class Main {

    static class Cla implements Comparable<Cla> {

        public String a, b, c;

        public Cla(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Main.Cla o) {
            if (Objects.equals(this.c, o.c)) {
                return this.a.compareTo(o.a);
            }
            return this.c.compareTo(o.c);
        }

        @Override
        public String toString() {
            return String.format("%s %s %s\n", a, b, c);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        try (Scanner in = new Scanner(new File("/Users/htdong/Desktop/gradle-has.txt"));
                FileWriter out = new FileWriter(new File("/Users/htdong/Desktop/v2.txt"));) {
            List<Cla> list = new ArrayList<>();
            while (in.hasNextLine()) {
                String[] s = in.nextLine().split(" ");
                String version = s[2].substring(s[2].lastIndexOf(":") + 1);
                list.add(new Cla(s[0], s[1], version));
            }
            list.sort(Cla::compareTo);
            for (Cla iter : list) {
                out.write(iter.toString());
            }
            out.flush();
        }
    }
}