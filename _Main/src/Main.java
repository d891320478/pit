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
        File f1 = new File("E:\\123.txt");
        File f2 = new File("E:\\4.txt");
        Scanner in = new Scanner(f1);
        BufferedWriter out = new BufferedWriter(new FileWriter(f2));
        while (in.hasNextLine()) {
            String s = in.nextLine();
            String[] t = s.split("#");
            String rlt = "INSERT INTO send_msg_to_leader ('gmt_create', 'gmt_modified', 'scope_id', 'app_type', 'from_uid', "
                    + "'from_uname', 'from_mobile', 'to_uid', 'to_uname', 'to_mobile') VALUES (now(), now(), "
                    + "'26', '1', " + "'" + t[2] + "', '" + t[0] + "', '" + t[1] + "', '" + t[5] + "', '" + t[3]
                    + "', '" + t[4] + "');";
            System.out.println(rlt);
            out.write(rlt + "\n");
        }
        in.close();
        out.flush();
        out.close();
        
    }

}