package poly;

public class Master {
    private String name;

    public Master(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }

    // 多态：本质为父类的引用指向子类对象，即Animal animal = new Dog dog;
    public void feed(Animal animal, Food food){
        System.out.println(name + "给" + animal.getName() + "喂" + food.getName());
    }
    // animal为编译类型，可以接受Animal子类的对象
    // 属性的值只看编译类型，不看对象

    // 动态绑定机制：当调用对象的方法时，该方法会和该
    // 对象的内存地址或运行类型绑定,当调用对象属性时则没有

}

