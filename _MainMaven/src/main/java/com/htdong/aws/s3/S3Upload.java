package com.htdong.aws.s3;

import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author dht31261
 * @date 2024年9月3日 14:25:23
 */
public class S3Upload {

    public static void main(String[] args) throws Throwable {
        URL presignedUrl = URI.create(
            "http://127.0.0.1:9000/ai-storage-dev/maasresourcemgr-init.sql?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20240903T063444Z&X-Amz-SignedHeaders=host&X-Amz-Credential=admin%2F20240903%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Expires=600&X-Amz-Signature=c7048dbc54afba207dc1d02e38e1ba215214073e6d30d674222cc4c89ed299a3")
            .toURL();
        HttpURLConnection connection = (HttpURLConnection)presignedUrl.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("PUT");
        try (OutputStream out = connection.getOutputStream();
            RandomAccessFile file = new RandomAccessFile("/Users/dht31261/Desktop/maasresourcemgr-init.sql", "r");
            FileChannel inChannel = file.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(8192);
            while (inChannel.read(buffer) > 0) {
                buffer.flip();
                for (int i = 0; i < buffer.limit(); i++) {
                    out.write(buffer.get());
                }
                buffer.clear();
            }
        }
        connection.getResponseCode();
    }
}