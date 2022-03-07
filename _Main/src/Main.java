/**
 * @author htdong
 */
public class Main {

    public static void main(String[] args) {
        long[] uids = new long[] { 84231840L, 10101001216628952L, 10101001230103296L, 10101001232215496L,
                10101001232341720L, 10101001232770760L, 10101001232871688L, 10101001232917072L, 10101001233076680L,
                10101001233077880L, 10101001233316544L, 10101001233797032L };
        long[] menus = new long[] { 391 };
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