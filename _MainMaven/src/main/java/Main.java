import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.shinemo.client.image.ImageUtil;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("E:\\static-world-logo.png");
        byte[] byteArrays = IOUtils.toByteArray(new FileInputStream(file));
        FileOutputStream fo = new FileOutputStream(new File("E:\\1.jpg"));
        fo.write(ImageUtil.compressToJpg(new ByteArrayInputStream(byteArrays)).toByteArray());
        fo.flush();
        fo.close();
    }

}
