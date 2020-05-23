package math;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author jujun chen
 * @date 2020/05/18
 */
public class BigDecimalTest {

    @Test
    public void construct() {
        BigDecimal bigDecimal = new BigDecimal(new char[]{'1','2','.','3'}, 1, 3);
        System.out.println(bigDecimal.toString());

        BigDecimal bigDecimal1 = new BigDecimal(new char[]{'1','2','.','5'}, 1, 3);
        System.out.println(bigDecimal1.toString());

        BigDecimal bigDecimal2 = new BigDecimal(new char[]{'1','2','.','5'}, 1, 3, MathContext.DECIMAL32);
        System.out.println(bigDecimal2.toString());

        //如果整数部分大于0，位数包括整数部分，如果整数部分小于0，只包括小数部分
        MathContext mathContext = new MathContext(1);
        BigDecimal bigDecimal3 = new BigDecimal("0.556", mathContext);
        System.out.println(bigDecimal3.toString());

        BigDecimal bigDecimal4 = new BigDecimal(0.1);
        BigDecimal bigDecimal5 = new BigDecimal("0.1");
        BigDecimal bigDecimal6 = new BigDecimal(Double.toString(0.1));
        BigDecimal bigDecimal7 = new BigDecimal(Double.valueOf(0.1));
        //0.1
        BigDecimal bigDecimal10 = BigDecimal.valueOf(0.1);

        System.out.println(bigDecimal4);
        System.out.println(bigDecimal5);
        System.out.println(bigDecimal6);
        System.out.println(bigDecimal7);
        System.out.println(bigDecimal10);

        BigDecimal bigDecimal8 = new BigDecimal(new BigInteger(String.valueOf(20)),1);
        System.out.println(bigDecimal8);

        BigDecimal bigDecimal9 = new BigDecimal(new BigInteger("12556"),3, new MathContext(2));
        System.out.println(bigDecimal9);
    }


    @Test
    public void valueOf() {
        BigDecimal bigDecimal = BigDecimal.valueOf(2,2);
        //0.02
        System.out.println(bigDecimal);
    }

    @Test
    public void add() {
        BigDecimal bigDecimal = new BigDecimal(10);
        BigDecimal bigDecimal1 = new BigDecimal(10.25);
        //20.3,两种不同的舍入方式
        BigDecimal result = bigDecimal.add(bigDecimal1, new MathContext(3));
        BigDecimal result2 = bigDecimal.add(bigDecimal1).setScale(1, RoundingMode.HALF_UP);
        System.out.println(result);
        System.out.println(result2);

        //减法 subtract
        //乘法 multiply
        //都类似
    }

    //除法
    @Test
    public void divide() {
        BigDecimal bigDecimal = new BigDecimal(10);
        BigDecimal bigDecimal1 = new BigDecimal(3);
        BigDecimal bigDecimal2 = bigDecimal.divide(bigDecimal1, 2, RoundingMode.HALF_UP);
        System.out.println(bigDecimal2);
        //小数精度0位
        BigDecimal bigDecimal3 = bigDecimal.divide(bigDecimal1, RoundingMode.HALF_UP);
        System.out.println(bigDecimal3);

        //java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
        //精确位数 this.scale() - divisor.scale()
//        BigDecimal bigDecimal4 = bigDecimal.divide(bigDecimal1);

        BigDecimal bigDecima4 = new BigDecimal("10");
        BigDecimal bigDecimal5 = new BigDecimal("3");
        BigDecimal bigDecimal6 = bigDecima4.divide(bigDecimal5);
        System.out.println(bigDecimal6);
    }

}
