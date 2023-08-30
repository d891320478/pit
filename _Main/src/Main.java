import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) throws IOException {
        try (ServerSocket socket = new ServerSocket(18765)) {
            while (true) {
                socket.accept();
            }
        }
    }
}