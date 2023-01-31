public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.toString().length());
        String[] s = sb.toString().split("-----");
        System.out.println(s.length);
    }
}