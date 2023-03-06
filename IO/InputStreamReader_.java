package IO;

import java.io.*;

// 可以将字节流转换为字符流，并可以指定编码
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\hello.txt";
        // 转换流，将Stream转为Reader
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath), "utf-8");
        // 包装
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        // 读取
        String s = bufferedReader.readLine();
        System.out.println(s);
        bufferedReader.close();

    }


}
