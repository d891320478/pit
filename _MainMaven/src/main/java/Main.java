import org.apache.commons.lang3.RandomStringUtils;

import com.shinemo.client.util.AESUtil;

public class Main {
    public static final String AES_SEED = "fd614444395d4977a58f5302cec6feb8";

    public static void main(String[] args) {
        System.err.println(RandomStringUtils.randomAscii(128));
        // System.out.println(AESUtil.encrypt("3e74c9ffbb674214aa82425183cfb370", AES_SEED));
        // System.out.println(AESUtil.encrypt("VYOHUNS88BGQ8SYNXBVQ", AES_SEED));
        // System.out.println(AESUtil.encrypt("jIKlM9llqSGYgDQZYkarzjkMs37S7kStXNiFeh6U", AES_SEED));
        System.out.println(AESUtil.generateSeed());
    }
}