import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

@SuppressWarnings("restriction")
public class ImageCompress {

    public static void main(String[] args) throws IOException {
        reduceImgAll(600, 600);
    }

    public static void reduceImgAll(int widthdist, int heightdist) {
        try {
            File[] srcfile = new File[] { new File("E:/1.gif") };
            if (srcfile != null) {
                for (int i = 0; i < srcfile.length; i++) {
                    if (srcfile[i].isFile() && (srcfile[i].getName().endsWith(".jpg")
                            || srcfile[i].getName().endsWith(".JPG") || srcfile[i].getName().endsWith(".gif")
                            || srcfile[i].getName().endsWith(".gif"))) {
                        Image src = javax.imageio.ImageIO.read(srcfile[i]);
                        BufferedImage tag = new BufferedImage((int) widthdist, (int) heightdist,
                                BufferedImage.TYPE_INT_RGB);
                        tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist, Image.SCALE_SMOOTH), 0,
                                0, null);
                        FileOutputStream out = new FileOutputStream("E:/temp_gif/" + srcfile[i].getName());
                        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
                        System.out.println(srcfile[i].getName());
                        encoder.encode(tag);
                        out.close();
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}