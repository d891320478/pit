import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author htdong
 */

class A {
    static int x = 1;
    int a;

    public A() {
        this.a = ++A.x;
    }

    public int get() {
        return a;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        List<A> list = Arrays.asList(new A(), new A(), new A(), new A(), new A());
        Integer[] s = list.stream().map(A::get).toArray(Integer[]::new);
        for (Integer i : s) {
            System.out.println(i);
        }
    }

}