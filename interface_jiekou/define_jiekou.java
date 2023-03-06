package interface_jiekou;

public class define_jiekou {
    // 接口就是给出一些没有实现的方法，封装到一起，到某个类
    // 要使用的时候，在根据具体情况把这些方法写出来
    // 细节：
    // 1.接口不能被实例化，接口不能继承类，但能继承其他接口
    // 2.一个类同时可以实现多个接口
    // 3.接口中的属性只能是public static final的
}
// 语法：
interface interface_name{
    // 属性
    // 抽象方法,只能用public修饰
    // jdk8后，可以有实现方法，但需要default关键字修饰
    // jdk8后，可以有静态方法
}
class class_name implements interface_name{
    // 必须实现接口的抽象方法

}

// 接口多态特性
// 1.只要一个实例对象实现了接口，就可以把这个实例对象传入接口对象实参中
// 比如calss_name 实现了interface_name接口，则
// calss_name A = new calss_name();
// 又有func(interface_name B), 则有func(A);
// 2.接口的编译类型可以 = 实现了接口的对象实例





