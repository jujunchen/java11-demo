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

        MathContext mathContext = new MathContext(3);
        BigDecimal bigDecimal3 = new BigDecimal("12.55", mathContext);
        System.out.println(bigDecimal3.toString());

        BigDecimal bigDecimal4 = new BigDecimal(0.1);
        BigDecimal bigDecimal5 = new BigDecimal("0.1");
        BigDecimal bigDecimal6 = new BigDecimal(Double.toString(0.1));
        BigDecimal bigDecimal7 = new BigDecimal(Double.valueOf(0.1));

        System.out.println(bigDecimal4);
        System.out.println(bigDecimal5);
        System.out.println(bigDecimal6);
        System.out.println(bigDecimal7);
    }

}
