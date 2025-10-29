import java.security.SecureRandom;
import java.util.Base64;

import org.apache.commons.lang3.RandomStringUtils;

public class Main {
    
    public static final String ROOT_KEY_FACTOR = "FjhhKQdXYUMtBUtsX1VuUjkDZy5XCyRzDSIxaSx+dltgHmQIWF4KZVsgPlQ4Bw8ATSkOKC0ud2ECHUBDNigdJXAkBRgfAFMlbmYIaBZDTDhABRJOXmI/M2xUd2hjcmhURFxhXnxza2UpYh9aGyhmPksgVQRkKVsePk10VzA9cyY=";

    public static void main(String[] args) {
        String a = RandomStringUtils.random(128, 0, 0, true, true, null, new SecureRandom());
        System.out.println(a);
        System.out.println(Base64.getEncoder().encodeToString(a.getBytes()));
        System.out.println(Base64.getDecoder().decode(ROOT_KEY_FACTOR).length);
    }

}