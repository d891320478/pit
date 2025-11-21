import org.apache.commons.lang3.Strings;

public class Main {

    public static void main(String[] args) {
        String a = "adfa";
        String b = "AdFa";
        System.out.println(Strings.CI.equals(a, b));
    }

}