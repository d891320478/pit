import java.util.Scanner;

public class NppSql {
    public static void main(String[] args) {
        String format = "insert into proxy_info (port, type, lan, name, client_id) values (%s, 1, '%s:22', '%s', 55);\n";
        Scanner in = new Scanner(System.in);
        int port = 28000;
        while (in.hasNext()) {
            String ip = in.next();
            String name = in.next();
            System.out.printf(format, ++port, ip, name);
        }

        format = "insert into machine (env, site_id, name, ip, proxy_ip, memo) values (0, 1, '%s', '%s:22', '192.168.47.62:%s', '%s');\n";
        port = 28000;
        while (in.hasNext()) {
            String ip = in.next();
            String name = in.next();
            System.out.printf(format, name, ip, ++port, name);
        }
        in.close();
        in.close();
    }
}
