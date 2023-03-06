import java.util.Scanner;
public class HelloWorld {
    public static void main(String[] args) {
        Dog.printHW();

        outx("邱");
//        int a[];
//        a = new int[5];

//        int a[] = new int[5];
        String b1 = "sdas";
        String b2 = "sd";
        System.out.println(b1.substring(1,2)); // [)
    }
    static int outx(String x){
        int num1 = Integer.parseInt("123");
        double num2 = Double.parseDouble("123");
        char ch = "123".charAt(2);
        // 接收用户输入
        Scanner myScanner = new Scanner(System.in);
        // String name = myScanner.next();
        // int age = Integer.parseInt(myScanner.next());
        int i = 10;
        return 0;
    }
}
class Dog{
    public static void printHW() {
        System.out.println("aaHello, World");
    }
}
/*
    编译 javac HelloWorld.java
    执行 java + 要执行的类名
    一个Java文件中只能有一个public class
    \r表示回车，即还是在当前行，但光标移到最前面
    数字 + 字符串 = 做拼接
    注意：浮点数做除法时即使整除结果也不会正确
          正确写法应该是两个数绝对值差值小于某个精度就相等
    // 定义数组: int a[] = new int[5] or int a[],使用时在a = new[5]
*/


