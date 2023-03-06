package IO;

import java.io.PrintStream;

public class PrintStream_ {
    public static void main(String[] args) {
        PrintStream out = System.out;
        out.print("hello!");
        // out.write("你好".getBytes());
        // 可以修改打印流输出的位置/设备
        // System.setOut(new PrintStream("e:\\hello.txt"));
        // System.out.print("hellllo!");既可以输出到屏幕上，也可以输出到指定的文件上
        out.close();
    }
}
