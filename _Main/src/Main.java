import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.time.LocalDate;

/**
 * @author htdong
 */

public class Main {

    public static void main(String[] args) {
        String a = LocalDate.now().toString();
        ReferenceQueue<String> rq = new ReferenceQueue<>();
        WeakReference<String> wr = new WeakReference<String>(a, rq);
        System.out.println(a);
        a = null;
        System.out.println(wr.get());
        System.out.println(rq.poll());
        System.gc();
        System.gc();
        System.gc();
        System.out.println(wr.get());
        System.out.println(rq.poll());
    }
}