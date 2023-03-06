package intger_string;

import java.util.Arrays;
import java.util.List;

public class about_arrays {

    public static void main(String[] args){
        Integer[] arr = new Integer[5];
        // 二分查找
        int idx = Arrays.binarySearch(arr, 1);
        // copy
        Integer[] newarr = Arrays.copyOf(arr, arr.length);
        // 填充
        Arrays.fill(arr, 100);
        // 比较数组内容是否一致
        boolean flag = Arrays.equals(arr, newarr);
        // 转换成List
        List<Integer> asList = Arrays.asList(arr);

    }
}
