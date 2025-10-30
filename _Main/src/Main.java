import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
        LocalDate d1 = LocalDate.parse("2025-10-10");
        LocalDate d2 = LocalDate.now();
        System.out.println(ChronoUnit.DAYS.between(d1, d2));
        System.out.println(ChronoUnit.DAYS.between(d2, d1));
    }
}