import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH时");
        System.out.println(format.format(new Date()));
    }
}