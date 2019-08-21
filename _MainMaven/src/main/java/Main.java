import com.shinemo.client.util.AESUtil;

public class Main {

    public static void main(String[] args) throws Exception {
        System.out.println(createClientId(123456L, 1).substring(0, 16));
    }

    private static String createClientId(Long siteId, Integer siteType) {
        String client = siteId.toString() + "#" + siteType.toString() + "#" + (System.currentTimeMillis() / 1000);
        return AESUtil.md5(client);
    }

}
