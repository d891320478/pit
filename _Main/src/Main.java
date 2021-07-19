import java.time.LocalTime;

/**
 * @author htdong
 */

public class Main {

	public static void main(String[] args) throws InterruptedException {
		int hour = LocalTime.now().getHour();
		System.out.println(hour);
	}
}