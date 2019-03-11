import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author htdong
 * @date 2018年12月28日 下午6:17:31
 */

public class Test {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("E:/2.txt"));
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] ss = s.split("\\(");
            ss[1] = ss[1].substring(0, ss[1].length() - 1);
            System.out.println(ss[1] + "(\"" + ss[1] + "\", \"" + ss[0] + "\"),");
        }
        in.close();
    }
}