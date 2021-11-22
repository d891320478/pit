/**
 * @author htdong
 */
public class Main {

    public static void main(String[] args) {
        Integer a = Integer.valueOf("1234");
        Integer b = Integer.valueOf("1234");
        System.out.println(System.identityHashCode(a));
        System.out.println(System.identityHashCode(b));
    }
}