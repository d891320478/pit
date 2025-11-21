public class Main {

    public static void main(String[] args) {
        String a = "adfa|afadf";
        String[] b = a.split("\\|");
        System.out.println(b.length);
        System.out.println(b[0]);
        System.out.println(b[1]);
    }
}