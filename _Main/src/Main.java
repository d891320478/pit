/**
 * @author htdong
 */
public class Main {

    public static void main(String[] args) {
        String a = "a1b2c3d456fre ";
        String[] b = a.replaceAll("[^0-9]", " ").split("\s+");
        System.out.println(b[0]);
        System.out.println(b[1]);
        System.out.println(b[2]);
        System.out.println(b[3]);
    }
}