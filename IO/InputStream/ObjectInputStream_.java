package IO.InputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
// 进行反序列化
// 反序列化的顺序和序列化的顺序保持一致
public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "e:\\hello.txt";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readChar());
        System.out.println(objectInputStream.readDouble());
        System.out.println(objectInputStream.readUTF());
        // 底层会把Object -> Dog
        Object dog = objectInputStream.readObject();
        System.out.println(dog);
        objectInputStream.close();


    }
}
