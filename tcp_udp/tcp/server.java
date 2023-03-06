package tcp_udp.tcp;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        try {
            // server端得有一个地址
            serverSocket = new ServerSocket(8001);
            // 等待客户端连接
            while (true) {
                socket = serverSocket.accept();
                // 读取客户端消息
                inputStream = socket.getInputStream();

                baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[10240];
                int len = -1;
                while ((len = inputStream.read()) != -1) {
                    baos.write(buffer, 0, len);
                }
                System.out.println(baos);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
