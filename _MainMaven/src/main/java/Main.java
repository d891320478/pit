import com.shinemo.net.bridge.server.util.TokenAuthenticator;

/**
 * @author htdong
 */

public class Main {

    public static void main(String[] args) {
        String keyPath = "D:/data/";
        TokenAuthenticator.initKeyPath(keyPath);
        System.out.println(TokenAuthenticator.check(
                "047DF7586AD3701CF6D3FA7875C4E14CE4DF49AAD9F73D14E369EA8CD8BF17EA1881FAF5CADD544FEB1BA3B099AB8628D45680BCB90F45C492EF637DCCE4FB1D7532AB7ADF853846CC222531BBBD0910F7082900D44FDADEFB5949FF7D6A0C06AC4B43F93163B7873919C9842F0595FDCF430E55D4D3BCF2F2807944C415F1C675174D2AEE2959"));
    }
}