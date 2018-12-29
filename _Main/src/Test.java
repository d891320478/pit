
/**
 *
 * @author htdong
 * @date 2018年12月28日 下午6:17:31
 */

public class Test {

    public static void main(String[] args) {
        String s = "9:商务座，P:特等座，M:一等座，O:二等座，6:高级软卧， 4:软卧，3:硬卧，2:软座，1:硬座";
        String[] ss = s.split("，");
        for (String i : ss) {
            String[] a = i.split(":");
            System.out.println("(\"" + a[0] + "\",\"" + a[1] + "\"),");
        }
    }
}