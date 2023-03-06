package tcp_udp.udp;

import java.io.IOException;
import java.net.*;

public class client {
    public static void main(String[] args) throws IOException {
        // 建立一个Socket
        DatagramSocket socket = new DatagramSocket();
        String msg = "Hello";
        // 发送给谁
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9090;
        // 建立一个包
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(),0, msg.getBytes().length, localhost, port);
        // 发送包
        socket.send(datagramPacket);
        socket.close();
    }
}
