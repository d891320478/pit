import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;

public class Main {

    public static void main(String[] args) {
        System.err.println(new String(new Base64().decode("PHA+5ZOI5ZOI5ZOIPC9wPg=="), Charset.forName("utf-8")));
    }
}