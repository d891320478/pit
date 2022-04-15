import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(5);
        set.add(6);
        System.out.println(set.lower(5));
        System.out.println(set.floor(4));
        System.out.println(set.floor(5));
        System.out.println(set.ceiling(2));
        System.out.println(set.ceiling(3));
        System.out.println(set.higher(2));
    }

}
