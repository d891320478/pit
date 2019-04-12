import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 
 * @author htdong
 */

public class Main {

    public static void main(String[] args) {
        System.out.print(LocalDateTime.ofInstant(new Date(1554796711000L).toInstant(), ZoneId.systemDefault()));
    }

}