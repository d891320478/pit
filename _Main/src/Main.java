import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        LocalDate d = LocalDate.now();
        System.out.println(d.minusDays(3922));
    }
}