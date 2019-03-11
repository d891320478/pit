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
            String[] ss = s.split("###");
            System.out.println("// " + ss[2]);
            System.out.println("private " + ss[1] + " " + ss[0] + ";");
        }
        in.close();
    }
}