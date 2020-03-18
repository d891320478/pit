import com.shinemo.client.util.AESUtil;

public class Main {

    public static void main(String[] args) {
        System.out.println(AESUtil.md5(
                "{\"clientId\":\"123\",\"clientSecret\":\"clientSecret\",\"method\":\"method\",\"postBody\":{\"idCardNo\":\"123456\"},\"timeStamp\":1234,\"token\":\"token\"}").toLowerCase());
    }
}