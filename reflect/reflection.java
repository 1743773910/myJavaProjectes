package reflect;

import java.lang.reflect.InvocationTargetException;

public class reflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 得到一个User对象
        Class c = Class.forName("reflect.User");

        // 一个类在内存中只有一个Class对象
        // 一个类被加载后，类的整个结构都会被封装在Class对象中

        // Class常用方法
        // 1.获得class对象
                // Class c = 实例.getClass();
                // Class c = Class.forName("类全名")
                // Class<类名> c = 类名.class;
        // 2.获得父类
        // Class c = 对象.getSupercalss()
        // 3.哪些类型有Class对象 -> class、interface、数组、枚举、void

        // 4.Class对象有什么用
        // 4.1 获得包名 + 类名-> c.getName()获得包名+类名，c.getSimpName()获得类名
        // 4.2 获得类的属性(public)-> Field[] fields = c.getFields("");
        //     获得全部属性 c.getDeclaredFields("可以指定属性")
        // 4.3 获得类的方法 c.getMethods[本类+父类public]  c.getDeclaredMethods[本类所有]
        // 4.4 获得指定构造器 c.getConstructor();
        // 4.5 构造一个对象 c.newInstance();// 必须要有无参构造器
        // 4.6 通过构造器创建对象
        //         Constructor con = c.getDeclaredConstructor(String.class, int.class);
        //         User user = (User)con.newInstance("Alex",1);
        // 4.7通过反射调用普通方法
        //     Method setName = c.getDeclaredMethod("setName", String.class);
        //     setName.invoke(c.newInstance(), "Alex");
        // 4.8 通过反射操作属性
        //      Field name = c.getDeclaredField("name");
        //      name.setAccessible(true); 因为是私有属性，所以要关掉安全检测
        //      name.set(c.newInstance(), "Alex");
        // 4.9 反射操作泛型
        // 4.10 反射操作注解
        //      Annotation[] an = c.getAnnotations(可以指定注解，指定后不是列表了,如注解.class); 获得全部注解
        //      Field f = c.getDeclaredField("name"); 获得指定注解
    }
}

class User{
    private String name;
    private int age;
    public User(String name, int age){
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    @Override
    public String toString(){
        return name + " " + age;
    }



}
