import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Main {

    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
        while (allNetInterfaces.hasMoreElements()) {
            NetworkInterface net = allNetInterfaces.nextElement();
            System.out.println(net.getDisplayName());
            if (net.isLoopback() || net.isVirtual() || !net.isUp()) {
                continue;
            }
            Enumeration<InetAddress> addresses = net.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress ip = addresses.nextElement();
                if (ip != null && ip instanceof Inet4Address) {
                    System.out.println(ip.getHostAddress());
                }
            }
        }
    }
}