package intger_string;

public class some_details_about_integer {
    /*
    （1）由于Integer变量实际上是对一个Integer对象的引用，
    所以两个通过new生成的Integer变量永远是不相等的
    （因为new生成的是两个对象，其内存地址不同）。
    Integer i = new Integer(100);
    Integer j = new Integer(100);
    System.out.print(i == j); //false

    （2）Integer变量和int变量比较时，只要两个变量的值是向等的，
    则结果为true（因为包装类Integer和基本数据类型int比较时，
    java会自动拆包装为int，然后进行比较，实际上就变为两个int变量的比较）
    Integer i = new Integer(100);
    int j = 100；
    System.out.print(i == j); //true

    （3）非new生成的Integer变量和new Integer()生成的变量比较时，
    结果为false。因为非new生成的Integer变量指向的是静态常量池
    中cache数组中存储的指向了堆中的Integer对象，
    而new Integer()生成的变量指向堆中新建的对象，
    两者在内存中的对象引用（地址）不同。
    Integer i = new Integer(100);
    Integer j = 100;
    System.out.print(i == j); //false

    （4）对于两个非new生成的Integer对象，进行比较时，
    如果两个变量的值在区间-128到127之间，则比较结果为true
    ，如果两个变量的值不在此区间，则比较结果为false
    Integer i = 100;
    Integer j = 100;
    System.out.print(i == j); //true

    Integer i = 128;
    Integer j = 128;
    System.out.print(i == j); //false
    对于第4条的原因： java在编译Integer i = 100 ;时，
    会翻译成为Integer i = Integer.valueOf(100)。
    而java API中对Integer类型的valueOf的定义如下，
    对于-128到127之间的数，会进行缓存，Integer i = 127时，
    会将127这个Integer对象进行缓存，下次再写
    Integer j = 127时，就会直接从缓存中取，就不会new了。
     */


}
