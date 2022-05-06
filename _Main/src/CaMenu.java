/**
 * @author htdong
 */
public class CaMenu {

    public static void main(String[] args) {
        long[] baasUids = new long[] { 8889006517L, 8889006041L, 8889006441L, 8889006508L, 8889006068L, 8889006514L,
                8889006012L, 8889006021L, 8889006052L, 8889006013L, 8889006019L, 8889006048L, 8889006016L, 8889006442L,
                8889006511L, 8889006065L, 8889006026L, 8889006507L, 8889006017L, 8889006069L, 8889006438L, 8889006040L,
                8889006439L, 8889006513L, 8889006042L, 8889006015L, 8889006018L, 8889006066L, 8889006516L, 8889006510L,
                8889006049L, 8889006064L, 8889006051L, 8889006504L, 8889006515L, 8889006020L, 8889006443L, 8889006063L,
                8889006023L, 8889006440L, 8889006437L, 8889006045L, 8889006506L, 8889006043L, 8889006047L, 8889006391L,
                8889006392L };
        long[] menus = new long[] { 386L };
        String sql = "insert into user_menu (site_id, app_id, menu_id, stat, gmt_create, kind, baas_uid) values (0, 7, %s, 1, now(), 0, %s);\n";
        for (int x = 0; x < baasUids.length; ++x) {
            for (long j : menus) {
                System.out.printf(sql, j + "", baasUids[x] + "");
            }
        }
    }
}