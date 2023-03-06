package tcp_udp.urlDownload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class about_url {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://leetcode.cn/");
        System.out.println(url.getProtocol()); // 协议
        System.out.println(url.getHost()); // IP
        System.out.println(url.getPort()); // 端口
        System.out.println(url.getPath()); // 全路径
        System.out.println(url.getFile()); // 文件
        System.out.println(url.getQuery()); // 参数

        // 连接到这个资源
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        // 获得流
        InputStream is = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("myfile.txt");
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read()) != -1){
            fos.write(buffer, 0, len);
        }
        fos.close();
        is.close();
        urlConnection.disconnect();
    }
}
