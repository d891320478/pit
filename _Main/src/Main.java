/**
 * 
 * @author htdong
 */

public class Main {

    static class Test {
        Integer a, b;
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.a = 0;
        System.out.println(t.b != null ? t.a - t.b : t.a);
    }

}