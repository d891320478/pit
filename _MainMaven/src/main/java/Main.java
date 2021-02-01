import com.shinemo.client.util.DistanceUtils;

/**
 * @author htdong
 */

public class Main {

    public static void main(String[] args) {
        String c1 = "123.1,23.2";
        String c2 = "115.854004,28.668377";
        System.out.println(DistanceUtils.getDistance(c1, c2));
    }
}