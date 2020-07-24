package text;

import org.junit.Test;

import java.text.ChoiceFormat;

/**
 * @author jujun chen
 * @date 2020/06/02
 */
public class ChoiceFormatTest {

    double[] limits = {1, 2, 3, 4, 5, 6, 7};
    String[] dayOfWeekNames = {"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"};
    ChoiceFormat form = new ChoiceFormat(limits, dayOfWeekNames);

    @Test
    public void test1() {
        for (int i = 0; i <= 8; ++i) {
            System.out.println(i + " -> " + form.format(i));
        }
    }

    /**
     * 获取模式字符串
     */
    @Test
    public void toPattern() {
        //1.0#Sun|2.0#Mon|3.0#Tue|4.0#Wed|5.0#Thur|6.0#Fri|7.0#Sat
        System.out.println(form.toPattern());
    }


    /**
     * 查找至少比两倍更大的d 。 如果NaN ，返回值相同
     */
    @Test
    public void nextDouble() {
        System.out.println(ChoiceFormat.nextDouble(10.3));
    }

    /**
     * 找到双倍小于d。如果是NaN ，则返回相同的值。
     */
    @Test
    public void previousDouble() {
        System.out.println(ChoiceFormat.previousDouble(10.3));
    }
}
