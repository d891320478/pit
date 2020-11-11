import java.math.BigDecimal;

/**
 * @author htdong
 */

public class Main {

    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal("12333333333333333333339.60");
        System.out.println(bd.setScale(2, BigDecimal.ROUND_FLOOR).stripTrailingZeros().toPlainString());
    }
}