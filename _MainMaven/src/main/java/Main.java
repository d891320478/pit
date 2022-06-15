import com.shinemo.client.util.AESUtil;

public class Main {
    public static final String AES_SEED = "fd614444395d4977a58f5302cec6feb8";

    public static void main(String[] args) {
        System.out.println(AESUtil.encrypt("VYOHUNS88BGQ8SYNXBVQ", AES_SEED));
        System.out.println(AESUtil.encrypt("jIKlM9llqSGYgDQZYkarzjkMs37S7kStXNiFeh6U", AES_SEED));
    }
}