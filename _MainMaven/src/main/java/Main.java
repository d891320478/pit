import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.shinemo.client.image.ImageUtil;

public class Main {

    public static void main(String[] args) throws IOException {
        File f = new File(
                "F:\\音乐\\YonderVoice\\YVD0001-絢爛キネトスコープ\\WallPaper\\Yukari of a Millennium 3840x2160.jpg");
        ByteArrayOutputStream out = ImageUtil.compressToJpg(new FileInputStream(f), 0.5, 0.75);
        FileOutputStream fo = new FileOutputStream(new File("E:\\3.jpg"));
        fo.write(out.toByteArray());
        out.flush();
        out.close();
        fo.flush();
        fo.close();
    }
}