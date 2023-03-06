package intger_string;

public class about_String {
//    String类构造器重载
//    String s1 = new String("");
//    String s2 = new String(char[] a);
//    String s3 = new String(char[] a, int startIdx, int cnt);
//    String s4 = new String(String original);
//    String s5 = new String(byte[]  b);

    // String 实现了接口Serializable,使String可以串行化，即在网络上传输
    //             接口Comparable,使String对象可以比较
    // String 是final类
    // String中属性private final char value[]:用于存放字符串内容
    // 注意value[]是一个final类型，即 字符串地址不能更改,值能修改

    // String 对象创建的两种方式
    // 直接赋值：String s1 = "Alex"
    // 调用构造器：String s2 = new String("Alex");
    // 其中，s1指向常量池的地址空间"Alex"
    // s2指向堆中的地址空间，s2中的value指向常量池的”Alex“

    // String a = "1";
    // String b = "2";
    // String c = a + b;
    // 其中c返回的是一个堆中的String对象

    // string有关方法
    /*
    .equals 判断内容是否相等
    .length
    .indexOf 获取字符第一次出现的idx
    .lastIndexOf
    .substring[start, end)
    .charAt 获取某处索引处的字符
    .concat("") 字符串拼接,返回一个对象
    .replace
    .split("符号") 以xx符号为标准进行分割得到一个String[]
    .format("%s  %d   %.2f",     )
     */
}
