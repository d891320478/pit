/**
 * @author htdong
 */
public class CaMenu {

    public static void main(String[] args) {
        long[] uids = new long[] { 10101001234659896L };
        long[] baasUids = new long[] { 8889006400L };
        long[] menus = new long[] { 365 };
        String sql = "insert into user_menu (site_id, uid, app_id, menu_id, stat, gmt_create, kind, baas_uid) values (0, %s, 7, %s, 1, now(), 0, %s);\n";
        for (int x = 0; x < uids.length; ++x) {
            for (long j : menus) {
                System.out.printf(sql, uids[x] + "", j + "", baasUids[x] + "");
            }
        }
    }
}