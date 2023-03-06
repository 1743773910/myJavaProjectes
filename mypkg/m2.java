package mypkg;

public class m2 {
    public static void main(String[] args){

    }

}
// 继承
class son extends par{
/*
继承要点
1.父类的非私有属性或方法可以直接在子类调用
  私有的属性或方法则需再写一个public，在public中调用
2.子类new时子类的构造器会调用父类及所有其的顶类的无参构造器，完成父类的初始化
3.若希望子类new时指定调用父类的某个构造器，则在子类构造器中super(参数)
4.super和this都只能放第一行，因此不能共存
5.java所有类都是Object的子类 extends Object

super要点
1.不能访问父类私有属性、私有方法，可以访问公有的  super.n1、super.test()
2.可以访问父类构造器,且访问构造器时必须放在子类的构造器中第一句
3.父子类中有重名的属性或方法时，要访问父类的属性和方法必须使用super.func
4.super的访问不限于父类，可以一直找到祖先类
5.总结：this访问先从子类开始查找，super直接从父类开始查找
*/

// 多态

}