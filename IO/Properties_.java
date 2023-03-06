package IO;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

// 可以读取配置文件、修改文件
// 要求配置文件格式为:
// key=value
// key=value
public class Properties_ {
    public static void main(String[] args) throws IOException {
        /*
        .load() 加载配置文件的键值对到Properties对象
        .list() 将数据显示到指定设备、流对象
        .getProperty(key) 根据key获取value
        .setProperty(key,value);
        .store():将properties中的键值对存储到配置文件中
         */
        Properties properties = new Properties();
        // 加载配置文件
        properties.load(new FileReader("e:\\hello.txt"));
        // 把k-v显示到控制台
        properties.list(System.out);
    }
}
