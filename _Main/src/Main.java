import java.time.LocalDateTime;

/**
 * @author htdong
 */
public class Main {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        now.plusDays(-7);
        System.out.println(now);
    }
}