import com.shinemo.client.util.AESUtil;

public class Main {
    public static final String AES_SEED = "fd614444395d4977a58f5302cec6feb8";

    public static void main(String[] args) {
        System.out.println(AESUtil.encrypt("0f2eaf9e2980f3ee2f7ec014b01e7057", AES_SEED));
        System.out.println(AESUtil.encrypt("RTFBMSAQININJ8BWM09M", AES_SEED));
        System.out.println(AESUtil.encrypt("bx17ttsiyp1T857XHJHxUEQFezpj6gk1xak6fPVg", AES_SEED));
    }
}