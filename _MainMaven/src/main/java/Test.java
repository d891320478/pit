import com.alibaba.fastjson2.JSON;

public class Test {

    public static void main(String[] args) {
        System.out.println(JSON.parseArray("[123,1234,123546,234]", Long.class));
    }
}