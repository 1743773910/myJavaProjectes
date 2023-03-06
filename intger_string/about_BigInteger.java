package intger_string;

import java.math.BigDecimal;
import java.math.BigInteger;

public class about_BigInteger {
    public static void main(String[] args){
        // 大数
        BigInteger bigint = new BigInteger("2315642316854651651651615613");
        /*
        + - * /
        bigint.add
        .subtract
        .multiply
        .divide
        把两个数都转成BigInteger对象加减乘除
         */

        // 高精
        BigDecimal bigdec = new BigDecimal("123.12346843545345345654565");
        // 高精度除法时可能除不尽，会抛出异常，因此得
        // bigdec.divide(bigdec2, BigDecimal.ROUND_CEILING)
        // 保留到和分子的精度相同

    }
}
