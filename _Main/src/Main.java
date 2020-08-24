/**
 * @author htdong
 */

public class Main {

    private static int singleNumber(int[] A) {
        int ones = 0;
        int twos = 0;
        int xthrees = 0;
        for (int i = 0; i < A.length; i++) {
            twos ^= (ones & A[i]);
            ones ^= A[i];
            xthrees = ~(ones & twos);
            twos &= xthrees;
            ones &= xthrees;
        }
        return ones;
    }

    public static void main(String[] args) {
    }
}