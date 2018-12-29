import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 * @author htdong
 */

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("E:/1.txt"));
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] ss = s.split("##");
            System.err.println(String.format("private @Setter @Getter @JsonProperty(\"%s\") String %s; // %s", ss[0],
                    f(ss[0]), ss[1]));
        }
        in.close();
    }

    private static String f(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '_') {
                ++i;
                sb.append((char)(s.charAt(i) - ('a' - 'A')));
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}