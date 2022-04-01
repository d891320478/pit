/**
 * @author htdong
 */
public class CaMenu {

    public static void main(String[] args) {
        long[] uids = new long[] { 96092960L, 10101001203632552L, 10101001210831456L, 10101001215337264L,
                10101001219714120L, 10101001229673928L, 10101001230429240L, 10101001231145928L, 10101001232241632L,
                10101001232529520L, 10101001232663304L, 10101001233016112L, 10101001233981576L };
        long[] menus = new long[] { 346, 354 };
        String sql = "insert into user_menu (site_id, uid, app_id, menu_id, stat, gmt_create, kind) values (0, %s, 7, %s, 1, now(), 0);\n";
        for (long i : uids) {
            for (long j : menus) {
                System.out.printf(sql, i + "", j + "");
            }
        }
    }
}