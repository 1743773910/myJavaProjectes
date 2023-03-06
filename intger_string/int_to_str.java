package intger_string;

public class int_to_str {
    public static void main(String[] args){
        // int to str
        Integer i = 100; // 自动装箱
        String str1 = i + "";
        String str2 = i.toString();
        String str3 = String.valueOf(i);

        // str to int
        String str4 = "12345";
        Integer i2 =  Integer.parseInt(str4); // 自动装箱
        Integer i3 = new Integer(str4);// 构造器

    }
}
