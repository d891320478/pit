import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * @author htdong
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("E:\\3.txt"));
        BufferedWriter out = new BufferedWriter(new FileWriter(new File("E:\\4.txt")));
        while (in.hasNextLine()) {
            String s = "update buy_order set refund_price = " + in.nextLine() + " where order_id = " + in.nextLine() + ";";
            out.write(s);
            out.flush();
        }
        in.close();
        out.close();
    }

}