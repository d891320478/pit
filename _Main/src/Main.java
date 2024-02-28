import java.util.Base64;

public class Main {

    public static void main(String[] args) {
        System.out.print(Base64.getEncoder().encodeToString(
            "{\"ecName\":\"云南省公路开发投资有限责任公司\",\"apId\":\"JTYJCL\",\"mobiles\":\"15957193120\",\"content\":\"1\",\"sign\":\"h9yS8gOi3\",\"addSerial\":\"\",\"mac\":\"1a4991d8d708424751e889b722e675ed\"}"
                .getBytes()));
    }
}