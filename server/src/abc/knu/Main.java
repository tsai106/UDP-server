package abc.knu;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Main {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(8000);
            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            do {
                ds.receive(dp);
                String s = new String(dp.getData(), 0, dp.getLength());
                System.out.println("收到:" + s);
            } while (true);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
