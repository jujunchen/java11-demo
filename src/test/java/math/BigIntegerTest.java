package math;

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

        BigInteger bigInteger1 = new BigInteger(bytes,0,1);
        System.out.println(bigInteger1);

        BigInteger bigInteger2 = new BigInteger(bytes);
        System.out.println(bigInteger2);

        //radix 表示进制
        BigInteger bigInteger3 = new BigInteger("10",10);
        System.out.println(bigInteger3);

        //随机数0-(2(3次方)-1)，0-7
        BigInteger bigInteger4 = new BigInteger(3, new Random());
        System.out.println(bigInteger4);

        BigInteger bigInteger5 = new BigInteger(3, 3, new Random());
        System.out.println(bigInteger5);
    }
}
