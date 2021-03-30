import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * @author htdong
 */

public class Main {

    public static String getSignature(String message, String secret, String hmacAlgorithm) {
        String signature = null;
        try {
            Mac mac = Mac.getInstance(hmacAlgorithm);
            SecretKeySpec secretKeySpec = null;
            try {
                secretKeySpec = new SecretKeySpec(secret.getBytes("UTF-8"), hmacAlgorithm);
                mac.init(secretKeySpec);
                BASE64Encoder base64 = new BASE64Encoder();
                signature = base64.encode(mac.doFinal(message.getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e) {
            }
        } catch (InvalidKeyException | NoSuchAlgorithmException e) {
        }
        return signature;
    }

    public static String getSignature(String message) {
        String signature = "";
        // 签名算法
        String algorithmForMac = "HmacSHA256";
        // 子账号秘钥
        String secret = "UnNDditTVytPdG5ib2VkMzl1YXlOQT09";
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // base64解密
            secret = new String(decoder.decodeBuffer(secret), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        signature = getSignature(message, secret, algorithmForMac);
        return signature;
    }

    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        String msg = "requestRefId=jxwangge1616983627094&secretId=979l8R2RX3418Gi10uYDS&x-date=Mon, 29 Mar 2021 02:07:07 GMT";
        System.out.println(getSignature(msg));
    }
}