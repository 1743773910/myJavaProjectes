package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// BufferedWriter和BufferedWriter是按照字符来读取数据的

public class BufferedReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\hello.txt";
        // 创建bufferedReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
        // 读取
        String line = null; // 按行读取
        while((line = line = bufferedReader.readLine()) != null){
            System.out.println(line);
        }
        bufferedReader.close(); // 关闭处理流时只需要关闭外层流即可
    }
}
