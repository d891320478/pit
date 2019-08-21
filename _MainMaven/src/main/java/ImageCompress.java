import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.shinemo.client.util.ImgUtil;

public class ImageCompress {

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream out = ImgUtil.compressToJpg(new FileInputStream(new File("E:/1.jpg")), 0.5, 0.5);
        FileOutputStream fileOut = new FileOutputStream(new File("E:/_1.jpg"));
        fileOut.write(out.toByteArray());
        fileOut.flush();
        fileOut.close();
    }
}