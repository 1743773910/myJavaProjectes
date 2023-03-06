package tcp_udp.upload_file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws Exception{
        // 创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        // 阻塞式连接，会一直等待客户端连接
        Socket socket = serverSocket.accept();
        // 获取输入流
        InputStream is = socket.getInputStream();
        // 文件输出
        FileOutputStream fos = new FileOutputStream(new File("receive.pdf"));
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read()) != -1){
            fos.write(buffer, 0, len);
        }
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
