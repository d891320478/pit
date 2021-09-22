/**
 * @author htdong
 */

public class Main {

    public static void main(String[] args) {
        String a = "我人有";
        byte[] b = a.getBytes();
        for (int i = 0; i < b.length; ++i) {
            System.out.println(b[i]);
        }
    }

}