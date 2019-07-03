import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ImageCompress {

    public static void main(String[] args) throws IOException {
        try (ZipInputStream zip = new ZipInputStream(new FileInputStream(new File("E:/1.zip")))) {
            ZipEntry entry;
            while ((entry = zip.getNextEntry()) != null) {
                byte[] buf = new byte[1024];
                int num = -1;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                while ((num = zip.read(buf, 0, buf.length)) != -1) {
                    baos.write(buf, 0, num);
                }
                String picName = entry.getName().trim();
                FileOutputStream out = new FileOutputStream(new File("E:/" + picName));
                out.write(baos.toByteArray());
                out.flush();
                out.close();
            }
        }
    }
}