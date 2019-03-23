import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;

/**
 * 
 * @author htdong
 */

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        LocalDate a = LocalDate.now();
        LocalDate b = LocalDate.of(2019, 3, 25);
        System.out.println(Period.between(a, b).getDays());
        System.out.println((Integer.MAX_VALUE - System.currentTimeMillis()/1000)/86400/365);
    }
}