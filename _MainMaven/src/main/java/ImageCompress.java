import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import com.madgag.gif.fmsware.AnimatedGifEncoder;
import com.madgag.gif.fmsware.GifDecoder;

public class ImageCompress {
    public static void main(String[] args) throws IOException {
        zoom(new File("E:/1.gif"), "E:/2.gif", 600, 600);
    }

    public static String zoom(File file, String targetPath, int width, int height) throws IOException {
        String formatName = getImageFormatName(file);
        if (null == formatName)
            return targetPath;
        formatName = formatName.toLowerCase();

        // 防止图片后缀与图片本身类型不一致的情况
        String pathPrefix = getPathWithoutSuffix(targetPath);
        targetPath = pathPrefix + formatName;

        // GIF需要特殊处理
        if (formatName.equals("gif")) {
            GifDecoder decoder = new GifDecoder();
            int status = decoder.read(new BufferedInputStream(new FileInputStream(file)));
            System.out.println(status);
            if (status != GifDecoder.STATUS_OK) {
                throw new IOException("read image " + file.getPath() + " error!");
            }

            AnimatedGifEncoder encoder = new AnimatedGifEncoder();
            encoder.start(targetPath);
            encoder.setRepeat(decoder.getLoopCount());
            for (int i = 0; i < decoder.getFrameCount(); i++) {
                encoder.setDelay(decoder.getDelay(i));
                BufferedImage image = zoom(decoder.getFrame(i), width, height);
                encoder.addFrame(image);
            }
            encoder.finish();
        } else {
            BufferedImage image = ImageIO.read(file);
            BufferedImage zoomImage = zoom(image, width, height);
            ImageIO.write(zoomImage, formatName, new File(targetPath));
        }

        return targetPath;
    }

    public static String getImageFormatName(File file) throws IOException {
        String formatName = null;

        ImageInputStream iis = ImageIO.createImageInputStream(file);
        Iterator<ImageReader> imageReader = ImageIO.getImageReaders(iis);
        if (imageReader.hasNext()) {
            ImageReader reader = imageReader.next();
            formatName = reader.getFormatName();
        }

        return formatName;
    }

    public static String getPathWithoutSuffix(String src) {
        String path = src;
        int index = path.lastIndexOf(".");
        if (index > 0) {
            path = path.substring(0, index + 1);
        }
        return path;
    }

    private static BufferedImage zoom(BufferedImage sourceImage, int width, int height) {
        BufferedImage zoomImage = new BufferedImage(width, height, sourceImage.getType());
        Image image = sourceImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        Graphics gc = zoomImage.getGraphics();
        gc.setColor(Color.WHITE);
        gc.drawImage(image, 0, 0, null);
        return zoomImage;
    }
}
