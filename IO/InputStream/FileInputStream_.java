package IO.InputStream;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

// 文件输入流(字节输入流)
public class FileInputStream_ {
    public static void main(String[] args) {

    }
    @Test
    public void readFile1() throws IOException {
        String filePath = "E:\\hello.txt";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        byte[] buffer = new byte[1024];
        int read;
        // fileInputStream.read(buffer, 0, buffer.length)从文件中最多读取length字节放入buffer数组中
        while ((read = fileInputStream.read(buffer, 0, buffer.length)) != -1){
            System.out.println(new String(buffer, 0, read));
        }
        fileInputStream.close();

    }
}
