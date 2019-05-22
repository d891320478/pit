import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 
 * @author htdong
 */

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(LocalDateTime.ofInstant(new Date(1558253324000L).toInstant(), ZoneId.systemDefault()));
    }
}