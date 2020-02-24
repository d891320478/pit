import java.util.Arrays;
import java.util.Map;

import com.google.common.collect.Maps;
import com.shinemo.client.util.UrlUtils;

public class Main {

    public static void main(String[] args) {
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("token", "1");
        String target = "http://api.jituancaiyun.net/apply-to-work/Findex.html#/detail?id=120";
        String[] targetSplit = target.split("#");
        if (targetSplit[targetSplit.length - 1].indexOf("?") != -1) {
            targetSplit[targetSplit.length - 1] = UrlUtils.encodeUrl(targetSplit[targetSplit.length - 1], paramMap);
        } else {
            targetSplit[0] = UrlUtils.encodeUrl(targetSplit[0], paramMap);
        }
        String url = Arrays.stream(targetSplit).reduce("", (valuePre, valueNext) -> valuePre + "#" + valueNext)
                .substring(1);
        System.out.println(url);
    }
}