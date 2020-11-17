import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.shinemo.client.common.lib.GsonUtil;
import com.shinemo.client.http.HttpConnectionUtil;
import com.shinemo.client.http.HttpResult;

public class Main {

    public static void main(String[] args) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("moduleCode", "APP-001-003");
        map.put("indexCycle", "4");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate ld = LocalDate.now();
        while (true) {
            map.put("indexTime", format.format(ld));
            Map<String, Object> header = new HashMap<>();
            header.put("Cookie", "mobile=15957193120;bossCode=79002819;selectAreaId=791;selectAreaLevel=2");
            HttpResult rr = HttpConnectionUtil.post(header,
                    "https://api.zbangong.cn/jxwangge-test/watch/index/check/report/detail", GsonUtil.toJson(map));
            JSONObject jo = JSONObject.parseObject(rr.getContent());
            Object list = ((JSONObject) jo.get("data")).get("indexList");
            System.out.println(ld);
            if (list != null && ((JSONArray) list).size() > 0) {
                break;
            }
            ld = ld.minusDays(1);
        }
    }
}