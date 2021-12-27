/**
 * @author htdong
 */
public class Main {

    public static void main(String[] args) {
        String str = "${ip}${ip}${ip}";
        System.out.println(str.replaceAll("\\$\\{ip\\}", "123"));
    }
}