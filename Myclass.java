import java.nio.file.Path;
import java.util.*;
public class Myclass {
    public static void main(String[] args){
//        String a1 = "123";
//        String a2 = "456";
//        StringBuilder A = new StringBuilder();
//        A.append("a1");
//        A.append("a2");
//        String B = A.toString();
//        System.out.println(B);
//        char[] C = B.toCharArray();
//        Scanner myscanner = new Scanner(System.in);
//        String name = myscanner.nextLine();
//        int age = myscanner.nextInt();

//        System.out.printf("%1$s %2$tB %2$te, %2$tY","Due date", new Date());


//        Cat cat1 = new Cat();
//        cat1.name = "a";
//        cat1.age = 10;
//        Date deadline = new Date();
//        String s = deadline.toString();
        Hspmethod T = new Hspmethod();
        String t = T.showScore("Alex", 1, 3, 5);
        System.out.println(t);
    }
}

class Cat{
    String name;
    int age;
}

class Hspmethod {

    public static String showScore(String name, double... scores){
        double total = 0;
        for(int i = 0; i < scores.length; i++){
            total += scores[i];
        }
        return name + "   " + total;
    }

    // 构造器：相当于PY中的__init__, new时自动执行，初始化
//    String name;
//    int age;
//    public Hspmethod(String name, int age){
//        this.name = name;
//        this.age = age;
    //      若用就近原则name = name则两个name都表示局部变量
    //      this代表当前对象的属性，即p = new Hspmethod(), this相当于p

//    }

}
