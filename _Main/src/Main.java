import java.util.Base64;

public class Main {

    public static void main(String[] args) {
        String s = "{\"command\":\"ps\", \"args\":[\"-ef\"]}";
        System.out.println(s);
        System.out.println(Base64.getEncoder().encodeToString(s.getBytes()));
        String t = "eyJjb21tYW5kIjogInNoIiwgImFyZ3MiOiBbIi9ob21lL2FkbWluL3dhdGNoZG9nL2Jpbi9jaGVja3NlLnNoIl19";
        System.err.println(new String(Base64.getDecoder().decode(t)));
    }
}