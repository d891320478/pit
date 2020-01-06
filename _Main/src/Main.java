import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * @author htdong
 */

public class Main {

    static class Test implements Serializable {

        private static final long serialVersionUID = -8326197189397666465L;

        private String a;
    }

    public static void main(String[] args) throws InterruptedException {
        Test t = new Test();
        Field[] f = t.getClass().getDeclaredFields();
        for (Field i : f) {
            System.out.println(i.getName());
        }
    }
}