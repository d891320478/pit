import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        System.out.println(
            LocalDateTime.parse("2020-01-02T23:15:00Z", DateTimeFormatter.ofPattern("YYYY-MM-dd'T'HH:mm:ssZ")));
    }
}