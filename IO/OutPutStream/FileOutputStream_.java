package IO.OutPutStream;

import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.IOException;

// 字节输出流
public class FileOutputStream_ {
    public static void main(String[] args) throws IOException {
        FileOutputStream_ fileOutputStream_ = new FileOutputStream_();
        fileOutputStream_.writeFile();
    }
    @Test
    public void writeFile() throws IOException {
        String fileName = "e:\\hello.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        // 设为true后文件操作改为append而不是覆盖
//        fileOutputStream.write('a'); // 方法一
        String str = "hello,world!我是"; // 方法二
        fileOutputStream.write(str.getBytes());
        fileOutputStream.close();
    }

}
