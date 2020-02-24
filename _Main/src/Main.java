/**
 * @author htdong
 */

public class Main {

    private static final String PARAM_TIMESTAMP = "timestamp";

    public static void main(String[] args) throws InterruptedException {
        String[] ss = "epidemic-admin?backDoor?".split("\\?");
        ss[1] = PARAM_TIMESTAMP + "=" + System.currentTimeMillis() + (ss[1] == null ? "" : "&" + ss[1]);
        System.out.println(String.join("?", ss));
    }
}