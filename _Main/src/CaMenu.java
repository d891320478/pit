/**
 * @author htdong
 */
public class CaMenu {

    public static void main(String[] args) {
        long[] baasUids = new long[] {8889006639L, 8889006317L, 8889006313L, 8889006320L, 8889006312L, 8889006304L,
            8889006299L, 8889006711L, 8889006791L, 8889006241L, 8889006242L, 8889006244L, 8889006250L, 8889006677L,
            8889006741L, 8889006742L, 8889006251L, 8889006249L, 8889006789L, 8889006844L};
        long[] menus = new long[] {354L};
        String sql =
            "insert into user_menu (site_id, app_id, menu_id, stat, gmt_create, kind, baas_uid) values (0, 7, %s, 1, now(), 0, %s);\n";
        for (int x = 0; x < baasUids.length; ++x) {
            for (long j : menus) {
                System.out.printf(sql, j + "", baasUids[x] + "");
            }
        }
    }
}