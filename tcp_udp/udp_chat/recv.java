package tcp_udp.udp_chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class recv implements Runnable{
    DatagramSocket socket = null;
    private int port;
    private String msgFrom;
    public recv(int port,String msgFrom){
        this.port = port;
        this.msgFrom = msgFrom;
        try {
            socket = new DatagramSocket(port);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while(true) {
            try {
                // 准备接受包裹
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container, 0, container.length);
                // 断开连接bye
                byte[] data = packet.getData();

                String recvDatas = new String(data, 0, data.length);
                System.out.println(msgFrom + ": " + recvDatas);
                if (recvDatas.equals("bye")) {
                    break;
                }
                // 阻塞式接受包裹
                socket.receive(packet);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
