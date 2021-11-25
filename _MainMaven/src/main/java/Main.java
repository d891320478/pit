import java.util.Date;

import com.shinemo.jce.util.Container;

/**
 * @author htdong
 */

public class Main {
    
    public static class A {
        private int a;
        
        public A(int a) {
            this.a = a;
        }
        
        public int getA() {
            return a;
        }
    }
    
    public static class B extends A {

        public B(int a) {
            super(a);
        }
        
    }
    
    static A a = new A(1);
    static B b = new B(2);

    public static void main(String[] args) {
        System.out.println(Container.get(A.class).getA());
        System.out.println(Container.get(B.class).getA());
    }

}