/**
 * @author htdong
 * @date 2018年12月28日 下午6:17:31
 */

public class Test {

    static final int resizeStamp(int n) {
        return Integer.numberOfLeadingZeros(n) | (1 << (16 - 1));
    }

    public static void main(String[] args) {
        System.out.println(resizeStamp(12));
    }
}