import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author htdong
 */

public class Main {
    
    private static class B {
        String c;
        public String getC() {
            return c;
        }
    }
    
    private static class A {
        B b;
        public B getB() {
            return b;
        }
    }

    public static void main(String[] args) throws IOException {
        A a = new A();
        a.b = new B();
        a.b.c = "2";
        Optional<A> opt = Optional.ofNullable(a);
        System.out.println(opt.map(A::getB).map(B::getC).orElse("222"));
    }

}