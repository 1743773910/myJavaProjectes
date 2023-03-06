package IO.OutPutStream;

import java.io.Serializable;

// 如果需要序列化某个类的对象，必须实现Serializable接口
public class Dog implements Serializable {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
