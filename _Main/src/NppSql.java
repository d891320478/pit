import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NppSql {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        String nppFormat = "insert into proxy_info (port, type, lan, name, client_id) values (%s, 1, '%s:22', '%s', 50);";
        String deployFormat = "insert into machine (env, site_id, name, ip, proxy_ip, memo) values (0, 53, '%s', '%s:22', '192.168.47.60:%s', '%s');";

        List<String> npp = new ArrayList<>();
        List<String> deploy = new ArrayList<>();

        Scanner in = new Scanner(new File("/Users/dht31261/Desktop/1.txt"));
        int port = 29000;
        while (in.hasNext()) {
            String name = in.next();
            String ip = in.next();
            ++port;
            npp.add(String.format(nppFormat, port, ip, name));
            deploy.add(String.format(deployFormat, name, ip, port, name));
        }
        in.close();
        npp.forEach(i -> System.out.println(i));
        Thread.sleep(100);
        deploy.forEach(i -> System.err.println(i));
    }
}
