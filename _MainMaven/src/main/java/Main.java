import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.shinemo.client.http.HttpConnectionUtil;

import lombok.Getter;
import lombok.Setter;

public class Main {

    @Setter
    @Getter
    public static class Sku {
        public String sku;
    }

    @Setter
    @Getter
    public static class Data {
        public List<Sku> list;
    }

    @Setter
    @Getter
    public static class Result {
        public boolean success;
        public Data data;
    }

    public static void main(String[] args) throws Exception {
        BufferedWriter out = new BufferedWriter(new FileWriter(new File("E:/sku.txt")));
        String url = "https://peliten-api.fxqifu.com/member/product_list";
        Map<String, Object> header = new HashMap<>();
        header.put("token", "62bda80b174c0f93e516252709b79fc6");
        Map<String, Object> param = new HashMap<>();
        param.put("supplier_type", 1);
        param.put("page_size", 200);
        int i = 1;
        Set<String> set = new HashSet<>();
        for (;; ++i) {
            param.put("page", i);
            Result rlt = HttpConnectionUtil.httpGet(url, param, header, Result.class);
            if (rlt.getData() == null) {
                break;
            }
            for (Sku iter : rlt.getData().getList()) {
                out.write(iter.getSku() + "\n");
                set.add(iter.getSku());
            }
        }
        System.err.println(i);
        System.err.println(set.size());
        out.flush();
        out.close();
    }

}
