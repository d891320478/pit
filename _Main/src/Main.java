/**
 * @author htdong
 */
public class Main {

    public static void main(String[] args) {
        long[] uids = new long[] { 99812416L, 10101001231961896L, 10101001228401944L, 10101001231981344L, 106104L,
                10101001229324392L, 10101001232145560L, 10101001231307328L, 10101001232668320L, 10101001232528920L };
        long[] menus = new long[] { 344, 357, 359, 365, 371, 378, 379, 383, 391, 392, 396, 382, 384, 385, 387, 388 };
        // String ins = "insert into user_menu (site_id, uid, app_id, menu_id, stat,
        // gmt_create, kind) values (0, %s, 7, 377, 1, now(), 0);\n";
        String sql = "insert into user_menu (site_id, uid, app_id, menu_id, stat, gmt_create, kind) values (0, %s, 7, %s, 1, now(), 0);\n";
        for (long i : uids) {
            for (long j : menus) {
                System.out.printf(sql, i + "", j + "");
            }
        }
    }
}