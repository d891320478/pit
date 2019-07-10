import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author htdong
 */

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = f.parse("1900-01-01 00:00:00");
        System.out.println(d.getTime() < 0);
    }
}