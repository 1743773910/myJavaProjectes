package intger_string;

public class about_StringBuffer {

    public static void main(String[] args){
        // 1.StringBuffer是final类
        // 2.StringBuffer实现了Serializable接口
        // 3.StringBuffer继承子抽象类AbstractStringBuilder
        // 的属性char[] value, 其不是final类，其内容在变幻时
        // 不用每次都变更地址对象

        StringBuffer stringbuffer = new StringBuffer();
        // 初始容量为16的char[],若有字符串参数传入，则容量为字符串.length + 16
        // 若有数字传入，则容量为该数字

        // String 和 StringBuffer的相互转换
        // 1.
        String s = "hello";
        StringBuffer strbuf = new StringBuffer(s);
        // 2.
        StringBuffer strbuf2 = new StringBuffer();
        strbuf2.append(s);

        // 3.
        String s1 = strbuf.toString();
        // 4.
        String s2 = new String(strbuf);

        // StringBuffer常用 方法
        /*
        .append
        .delete[start, end)
        .replace(start, end, string)
        .indexOf(char or substr) 第一次出现的索引
        .insert(idx, string)
        .length
         */
    }
}
