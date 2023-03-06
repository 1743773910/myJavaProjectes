package tcp_udp.udp_chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class send implements Runnable{
    DatagramSocket socket = null;
    BufferedReader reader = null;
    private int fromPort;
    private String toIP;
    private int toPort;
    public send(int fromPort, String toIP, int toPort){
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;
        try{
            socket = new DatagramSocket(fromPort);
            // 从控制台读取消息
            reader = new BufferedReader(new InputStreamReader(System.in));
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        while(true) {
            try {
                String data = reader.readLine();
                byte[] datas = data.getBytes();

                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.toIP, this.toPort));
                socket.send(packet);
                if (data.equals("bye")) {
                    break;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        socket.close();
    }
}
