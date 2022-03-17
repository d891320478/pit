/**
 * @author htdong
 */
public class CaMenu {

    public static void main(String[] args) {
        long[] uids = new long[] { 10101001233619744L, 77530504L, 10101001230693160L, 10101001232946024L,
                10101001232897904L, 10101001233994704L, 10101001231084136L, 10101001233635368L };
        long[] menus = new long[] { 344, 345, 357, 359, 360, 361, 371, 378, 379, 383, 391, 392, 396, 402 };
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