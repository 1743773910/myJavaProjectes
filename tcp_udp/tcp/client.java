package tcp_udp.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class client {
    public static void main(String[] args){
        Socket socket = null;
        OutputStream os = null;
        try{
            // 服务器地址、端口号
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            int port = 8001;
            // 创建一个socket链接
            socket = new Socket(serverIP, port);
            // 发送消息：IO流
            os = socket.getOutputStream();
            os.write("你好".getBytes());
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(os != null){
                try{
                    os.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try{
                    socket.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

        }
    }
}
