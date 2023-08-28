import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Main {

    public static void main(String[] args) throws IOException {
        try (DatagramSocket ds = new DatagramSocket(23456)) {
            DatagramPacket p = new DatagramPacket(new byte[256], 256);
            for (int i = 0; i < 10; ++i) {
                ds.receive(p);
                System.out.println(new String(p.getData()));
            }
        }
    }
}