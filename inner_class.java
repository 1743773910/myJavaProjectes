public class inner_class {
    public static void main(String[] args){
        Outer outer = new Outer();
        outer.method();
        outer.method3();
        // 匿名内部类细节:
        // 1.匿名内部类是一个实例对象
        // 2.匿名内部类默认继承某个继承父类
        // 3.匿名内部类内部可以重写方法
        // 4.可以直接访问外部所有成员,但不能添加访问修饰符
        // 5.外部类和匿名内部类成员有重名时，访问遵循就近原则，
        // 若要在内部类中访问外部的重名成员,则用外部类名.this.func()

    }
}

// 匿名内部类
class Outer{
    // 1.基于接口的匿名内部类
    // 匿名内部类只使用一次后就废弃
    public void method(){
        IA tiger = new IA(){
        public void cry() {
            System.out.println("tiger is crying");
        }
        };
        tiger.cry();
    }

    // 2.基于类的匿名内部类
    public void method3(){
        B b = new B(){
            public void method2(){
                System.out.println("this is new class B");
            }
        };
        b.method2();
    }

    // 3.基于抽象类的匿名内部类

}

interface IA{
    public void cry();
}

class B{
    public void method2(){
        System.out.println("this is calss B");
    }
}