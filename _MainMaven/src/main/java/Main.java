import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.shinemo.client.util.ImgUtil;

public class Main {

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream out = ImgUtil.compressToJpg(new FileInputStream(new File("E:\\表情包本地化\\商品图\\DSC_0001.JPG")),
                0.3, 0.8);
        FileOutputStream writer = new FileOutputStream("E:/1.jpg");
        writer.write(out.toByteArray());
        writer.close();
    }
}