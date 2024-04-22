public class Main {

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 12; ++i) {
            int j = i;
            while (j > 0) {
                sum += j % 10;
                j /= 10;
            }
        }
        System.out.println(sum);
    }
}