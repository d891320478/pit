import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日HH时");
        System.out.println(format.format(new Date()));
        System.out.println(TimeUnit.HOURS.toSeconds(1));
        List<String> list = Arrays.asList("123", "qwef", "easdf");
        System.out.println(list.toString());
    }
}