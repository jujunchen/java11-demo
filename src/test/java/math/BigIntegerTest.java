package math;

import java.math.BigInteger;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author jujun chen
 * @date 2020/05/26
 */
public class BigIntegerTest {

    @Test
    public void test() {
        BigInteger bigInteger = new BigInteger("-9");
        byte[] bytes = bigInteger.toByteArray();
        System.out.println(Arrays.toString(bytes));

        BigInteger bigInteger1 = new BigInteger(bytes, 0, 1);
        System.out.println(bigInteger1);

        BigInteger bigInteger2 = new BigInteger(bytes);
        System.out.println(bigInteger2);

        //radix 表示进制
        BigInteger bigInteger3 = new BigInteger("10", 10);
        System.out.println(bigInteger3);

        //随机数0-(2(3次方)-1)，0-7
        BigInteger bigInteger4 = new BigInteger(3, new Random());
        System.out.println(bigInteger4);

        BigInteger bigInteger5 = new BigInteger(3, 3, new Random());
        System.out.println(bigInteger5);
    }

    /**
     * 返回指定bitLength位数的正素数
     */
    @Test
    public void probablePrime() {
        BigInteger bigInteger = BigInteger.probablePrime(2, new Random());
        System.out.println(bigInteger);
    }

    /**
     * 返回大于指定BigInteger的第一个素数
     */
    @Test
    public void nextProbablePrime() {
        BigInteger bigInteger = new BigInteger("3");
        System.out.println(bigInteger.nextProbablePrime());
    }

    /**
     * 返回数组，0位置表示平方根的整数s，1位置表示this-s*s
     */
    @Test
    public void sqrtAndRemainder() {
        BigInteger bigInteger = new BigInteger("3");
        System.out.println(Arrays.toString(bigInteger.sqrtAndRemainder()));
    }

    /**
     * 求两数绝对值的最大公约数
     */
    @Test
    public void gcd() {
        BigInteger bigInteger = new BigInteger("2");
        BigInteger bigInteger2 = new BigInteger("-4");
        System.out.println(bigInteger.gcd(bigInteger2));
    }

    /**
     * 返回此BigInteger的否定值
     */
    @Test
    public void negate() {
        BigInteger bigInteger = new BigInteger("2");
        System.out.println(bigInteger.negate());
        BigInteger bigInteger1 = new BigInteger("-2");
        System.out.println(bigInteger1.negate());
    }


    /**
     * 返回表示BigInteger的正负数，1表示正数，0表示零，-1表示负数
     */
    @Test
    public void signum() {
        BigInteger bigInteger = new BigInteger("2");
        System.out.println(bigInteger.signum());
    }


    /**
     * 取模，模数始终为正数
     */
    @Test
    public void mod() {
        BigInteger bigInteger = new BigInteger("-5");
        //java.lang.ArithmeticException: BigInteger: modulus not positive
//        BigInteger bigInteger1 = new BigInteger("-2");
        BigInteger bigInteger1 = new BigInteger("2");
        System.out.println(bigInteger.remainder(bigInteger1));
        System.out.println(bigInteger.mod(bigInteger1));
    }

    /**
     * 返回<code>this<sup>exponent</sup> mod m</code>
     */
    @Test
    public void modPow() {
        BigInteger bigInteger = new BigInteger("2");
        BigInteger bigInteger1 = new BigInteger("3");
        System.out.println(bigInteger.modPow(new BigInteger("2"), bigInteger1));
    }

    /**
     * 返回{@code this}<sup>-1</sup> {@code mod m}
     */
    @Test
    public void modInverse() {
        BigInteger bigInteger = new BigInteger("1");
        System.out.println(bigInteger.modInverse(new BigInteger("6")));
    }

    /**
     * 返回值为(this << n)的BigInteger。 移位距离n可以是负的，表示右移，取值往小的靠。（计算floor(this * 2n次方) ）
     */
    @Test
    public void shiftLeft() {
        BigInteger bigInteger = new BigInteger("1");
        BigInteger bigInteger1 = new BigInteger("-2");
        System.out.println(bigInteger.shiftLeft(2));
        System.out.println(bigInteger1.shiftLeft(2));
    }

    /**
     * 返回值为(this >> n)的BigInteger。移位距离n可以是负的，执行左移，取值往小的靠。 （计算floor(this / 2n次方) ）
     */
    @Test
    public void shiftRight() {
        BigInteger bigInteger = new BigInteger("1");
        BigInteger bigInteger1 = new BigInteger("-2");
        System.out.println(bigInteger.shiftRight(2));
        System.out.println(bigInteger1.shiftRight(2));
    }

    /**
     * 返回值为(this & val)的BigInteger。 （当且仅当this和val都为负时，此方法返回负BigInteger。）
     */
    @Test
    public void and() {
        BigInteger bigInteger = new BigInteger("1");
        BigInteger bigInteger1 = new BigInteger("1");
        System.out.println(bigInteger.and(bigInteger1));

        BigInteger bigInteger2 = new BigInteger("-1");
        System.out.println(bigInteger.and(bigInteger2));

        BigInteger bigInteger3 = new BigInteger("-1");
        System.out.println(bigInteger2.and(bigInteger3));
    }

    /**
     * 返回值为(this | val)的BigInteger。 （当且仅当this或val为负数时，此方法返回负BigInteger。）
     */
    @Test
    public void or() {
        BigInteger bigInteger = new BigInteger("1");
        BigInteger bigInteger1 = new BigInteger("-1");
        System.out.println(bigInteger.or(bigInteger1));
    }

    /**
     * 返回值为(this ^ val)的BigInteger。 （当且仅当此和val中的一个为负时，此方法返回负BigInteger。）
     * 1 xor 1 = -2
     * 二进制：000000001
     * <p>
     * -1反码：111111110
     * <p>
     * 补码：111111111
     * <p>
     * 异或一个1就变成了111111110
     * <p>
     * 然后补码转反码减1得111111101
     * <p>
     * 去掉负号(反码转回来)得到000000010(2)
     * <p>
     * 添回符号就变成-2了。
     */
    @Test
    public void xor() {
        BigInteger bigInteger = new BigInteger("1");
        BigInteger bigInteger1 = new BigInteger("-1");
        System.out.println(bigInteger.xor(bigInteger1));
    }

    /**
     * 返回值为(~this)的BigInteger。 （当且仅当此BigInteger为非负数时，此方法才返回负值。）
     */
    @Test
    public void not() {
        BigInteger bigInteger = new BigInteger("1");
        System.out.println(bigInteger.not());
    }

    /**
     * 返回值为(this & ~val)的BigInteger。 该方法等同于and(val.not()) ，是为了屏蔽操作的便利而提供的。（当且仅当this为负且val为正时，此方法返回负BigInteger。）
     */
    @Test
    public void andNot() {
        BigInteger bigInteger = new BigInteger("1");
        System.out.println(bigInteger.andNot(new BigInteger("-1")));
    }

    /**
     * 当且仅当指定位置位时，返回true 。 （计算((this & (1<<n)) != 0) ）
     * 参数
     * n - 要测试的位索引。
     * 结果
     * true当且仅当指定位置位时。
     */
    @Test
    public void testBit() {

    }


    /**
     * 返回一个BigInteger，其值等于此BigInteger并设置了指定的位。 （计算(this | (1<<n)) ）
     * 参数
     * n - 要设置的位索引。
     * 结果
     * this | (1<<n)
     */
    @Test
    public void setBit() {
        BigInteger bigInteger = new BigInteger("1");
        System.out.println(bigInteger.setBit(1));
    }


    /**
     * 返回一个BigInteger，其值等于此BigInteger且指定位已清除。 （计算(this & ~(1<<n)) ）
     */
    @Test
    public void clearBit() {

    }

    /**
     * 返回一个BigInteger，其值等于此BigInteger，并且指定的位被翻转。 （计算(this ^ (1<<n)) ）
     * 参数
     * n - 要翻转的位索引。
     * 结果
     * this ^ (1<<n)
     */
    @Test
    public void flipBit() {
        BigInteger bigInteger = new BigInteger("1");
        System.out.println(bigInteger.flipBit(1));
    }


    /**
     * 返回此BigInteger中最右边（最低位）一位的索引（最右边一位右边的零位数）。 如果此BigInteger不包含任何位，则返回-1。 （计算(this == 0? -1 : log2(this & -this)) ）
     * 结果
     * 此BigInteger中最右边一位的索引
     */
    @Test
    public void getLowestSetBit() {
        BigInteger bigInteger = new BigInteger("10");
        System.out.println(bigInteger.getLowestSetBit());
    }


    /**
     * 返回此BigInteger的最小二进制补码表示的位数， 不包括符号位。 对于正BigIntegers，这相当于普通二进制表示中的位数。 对于零，此方法返回0 。 （计算(ceil(log2(this < 0 ?
     * -this : this+1))) ）
     * 结果
     * 此BigInteger的最小二进制补码表示中的位数， 不包括符号位。
     */
    @Test
    public void bitLength() {
        BigInteger bigInteger = new BigInteger("-2");
        System.out.println(bigInteger.bitLength());
    }


    /**
     * 返回此BigInteger的二进制补码表示中与其符号位不同的位数。 在BigIntegers上实现位向量样式集时，此方法很有用。
     * 结果
     * 此BigInteger的二进制补码表示中的位数与其符号位不同
     */
    @Test
    public void bitCount() {
        BigInteger bigInteger = new BigInteger("-1");
        System.out.println(bigInteger.bitCount());
    }

    /**
     * 返回true如果此BigInteger可能为素数， false ，如果它一定为合。 如果certainty是0，则返回true 。
     * 结果
     * true如果这个BigInteger可能是素数， false如果它肯定是复合的。
     */
    @Test
    public void isProbablePrime() {
        BigInteger bigInteger = new BigInteger("3");
        System.out.println(bigInteger.isProbablePrime(2));
    }


    /**
     * 含有此BigInteger的二进制补码表示的字节数组。
     */
    @Test
    public void toByteArray() {
        BigInteger bigInteger = new BigInteger("-1");
        System.out.println(Arrays.toString(bigInteger.toByteArray()));

        System.out.println(Integer.toBinaryString(-1));
    }

}
