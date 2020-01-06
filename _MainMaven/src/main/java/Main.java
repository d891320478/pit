import com.shinemo.client.util.AESUtil;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(AESUtil.tclyDecrypt(
                "d6sfSBcH_-RIWMiAnWpKx7SJeNXtNbKdoPRLn1GcPig2ISMloYFY5rIESe5ZWIFwcLyQAXJm9To1ewf8fHFIw-7tIJ6r5pUrGNKj3GzsmDKLwJBqer1Nr-3AnnlN3h-ELmE3zb_AAI-CVUotHsv3GNhxqzY4gcxYHcBr4GTHnZA",
                "11e7b72651134fdca2d2"));
    }
}