package abc.knu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {
    public static void main(String[] args) {
        try {
            final int PORT = 8000;

            // 建立一個DataramSocket物件
            DatagramSocket ds = new DatagramSocket();

            // 取得接收端的電腦位址
            InetAddress address = InetAddress.getByName("10.2.8.216");

            // 要求使用者輸入字串
            String str;

            do {
                BufferedReader keyin;
                keyin = new BufferedReader(
                        new InputStreamReader(System.in));

                System.out.print("請輸入字串：");
                str = keyin.readLine();

                // 將字串包裝成DatagramPacket物件
                DatagramPacket dp = new DatagramPacket(str.getBytes(),	// 資料的位置
                        str.length(),	// 資料的大小，以byte或word（可傳中文）為單位
                        address,		// 接收端的電腦位址
                        PORT);		// 接收端的port

                // 將DatagramPacket物件送出
                ds.send(dp);
            } while (!str.equals(""));

            System.out.println("結束！");

            // 關閉Socket
            ds.close();
        }
        catch (Exception e) {
            System.out.println("UdpClient fails.");
        }
    }
}
