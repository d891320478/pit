import java.util.Date;

/**
 * 
 * @author htdong
 */

public class Main {
    
    private static void test(long t) {
        test(Long.valueOf(t));
    }
    
    private static void test(Long t) {
        System.err.println(t);
    }

    public static void main(String[] args) {
        test(1);
        System.err.println(3>>1&1);
    }

}