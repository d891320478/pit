import java.util.Date;

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
        System.out.println(new Date(5983751901404394L));
        System.out.println(singleNumber(new int[] { -1, 2, 3, -1, 2, 3, -1, -4, 2, 3 }));
    }
}