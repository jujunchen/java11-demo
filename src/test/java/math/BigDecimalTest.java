package math;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;

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
    }

}
