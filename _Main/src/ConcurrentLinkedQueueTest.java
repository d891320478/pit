import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException {
        ConcurrentLinkedQueue<Integer> q = new ConcurrentLinkedQueue<>();
        q.add(1);
        Class<?> clazz = Class.forName("java.util.concurrent.ConcurrentLinkedQueue");
        Field field = clazz.getDeclaredField("head");
        field.setAccessible(true);
        Object o1 = field.get(q);
        Class<?> headCl = clazz.getDeclaredField("head").getType();
        Field headFi = headCl.getDeclaredField("item");
        headFi.setAccessible(true);
        System.out.println(headFi.get(o1));
        System.out.println(q.peek());
    }
}
