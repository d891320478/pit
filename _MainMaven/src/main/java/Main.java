import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.shinemo.client.common.lib.GsonUtil;

/**
 * @author htdong
 */

public class Main {

    public static void main(String[] args) throws IOException {
        File f = new File("/User/htdong/Desktop/config copy.js");
        StringBuilder sb = new StringBuilder();
        try (FileReader fin = new FileReader(f)) {
            char[] b = new char[1024];
            for (int n = fin.read(b); n != -1; n = fin.read(b)) {
                sb.append(b);
            }
        }
        List<Path> list = GsonUtil.fromJsonToList(sb.toString(), Path[].class);
    }

    public static class Path {
        private String title;
        private String path;
        private List<Path> routes;
    }
}