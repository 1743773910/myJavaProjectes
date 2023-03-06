package set;

import java.util.*;

public class about_collection {
    /*
    add
    remove
    size
    contains
    clear
    isEmpty
     */

    public static void main(String[] args){
        // 1.List:相当于数组,存取有序
        List<String> col = new ArrayList<>();
        /*
        add(idx, x)
        add(x)
        get(idx)
        set(idx, x) 修改元素,然后返回原来的元素
        remove(idx)
        indexOf(Object o)
         */

        // 迭代器(单向游标)
        Iterator<String> iterator = col.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        // 双向游标
        ListIterator<String> stringListIterator = col.listIterator();
        while(stringListIterator.hasNext()){
            System.out.println(stringListIterator.next());
        }
        while(stringListIterator.hasPrevious()){
            System.out.println(stringListIterator.previous());
        }

         // 2.HashSet 无序、不重复
        Set<String> set = new HashSet();
        // 1.HashSet中add可以充当修改，其他方法都一样
        // 2.遍历一样可以增强for或者迭代器遍历
        // 3.怎样编译器判断不重复?
        // 首先判断hashcode(), 不同则不等,若相等
        // 则用equals判断两个对象，false则不等
        // 4.添加一个集合到另一个集合就是把该集合中的所有元素添加到另一个集合
        // 5.将一个集合转化为一个数组，数组确定不了类型，因此用根基类
        // Object objects = set.toArray(可以传入类型如Integer、String,若传入则不能用根基类);

        // 3.map 无序、不重复
        Map<Integer, String> map = new HashMap<>();
        map.put(100, "100");
        map.size();
        // 遍历方式六种
        Collection<String> values = map.values();
        for(String tmp: values){

        }
        Iterator<String> iterator2 = values.iterator();
        while(iterator2.hasNext()){
           iterator2.next();
        }

        Set<Integer> keys = map.keySet();
        for(Integer key: keys){
            map.get(key);
        }
        Iterator<Integer> iterator3 = keys.iterator();






    }
}

class Mymap<K, V>{
    private MyEntey entey;
    public void put(K k, V v){
        new MyEntey<>(k, v);
    }

    class MyEntey<K, V>{
        private K k;
        private V v;
        public MyEntey(K k, V v){
            this.k = k;
            this.v = v;
        }
    }
}
