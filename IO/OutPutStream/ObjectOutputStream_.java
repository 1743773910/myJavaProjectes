package IO.OutPutStream;

import chess.loginSystem.Message;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

// ObjectOutputStream用于数据的序列化,以保存数据和其数据类型
// 序列化后保存文件的格式不是纯文本
// 序列化对象时，除了static和transient修饰的成员(不会保存null)，其余均序列化
// 序列化具备可继承性，即如果祖类实现了序列化，则其子类也已默认实现序列化
// 序列化对象时，要求里面的属性也需要实现序列化接口
public class ObjectOutputStream_ {
    public static void main(String[] args) throws IOException {
        String filePath = "e:\\hello.txt";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        objectOutputStream.writeInt(100); // int -> Integer
        objectOutputStream.writeChar('a'); // char -> Character
        objectOutputStream.writeDouble(9.5); // double -> Double
        objectOutputStream.writeUTF("123"); // String
        objectOutputStream.writeObject(new Dog("111", 10)); // 保存对象
        objectOutputStream.close();
    }
}

