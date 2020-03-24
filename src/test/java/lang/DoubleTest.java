package lang;

import org.junit.Test;

/**
 * @author jujun chen
 * @date 2020/03/23
 */
public class DoubleTest {

    /**
     * 返回double参数的字符串表示形式
     */
    @Test
    public void toString1() {
        double d = 0;
        System.out.println(Double.toString(d));

        Double d1 = Double.valueOf(0.0);
        System.out.println(d1.toString());
    }

    /**
     * 返回double参数的十六进制字符串
     *
     * 如果参数为NaN，则结果为字符串“ NaN ”。
     * 否则，结果是一个表示参数的符号和大小的字符串。 如果符号为负，则结果的第一个字符为' - '（ '\u002D' ）; 如果符号为正，则结果中不会出现符号字符。 至于幅度m ：
     * 如果m是无穷大，则由字符串"Infinity"表示; 因此，正无穷大产生结果"Infinity" ，负无穷大产生结果"-Infinity" 。
     * 如果m为零，则由字符串"0x0.0p0"表示; 因此，负零产生结果"-0x0.0p0" ，正零产生结果"0x0.0p0" 。
     * 如果m是具有规范化表示的double值，则子串用于表示有效数和指数字段。 有效数字由字符"0x1."表示，后跟有效数字的其余部分的小写十六进制表示形式作为分数。
     * 除非所有数字都为零，否则将删除十六进制表示中的尾随零，在这种情况下使用单个零。 接下来，指数由"p"表示，后跟无偏指数的十进制字符串，就好像通过对指数值调用Integer.toString产生的一样。
     * 如果m是具有次正规表示的double值，则有效数字由字符"0x0."表示，后跟有效数字的其余部分的十六进制表示形式作为分数。 删除十六进制表示中的尾随零。 接下来，指数由"p-1022"表示。
     * 请注意，在次正规有效数中必须至少有一个非零数字。
     */
    @Test
    public void toHexString() {
        double d = 0;
        System.out.println(Double.toHexString(d));
        double d1 = 3.0;
        System.out.println(Double.toHexString(d1));
    }
    
    @Test
    public void valueOf() {
        /*
        返回Double对象，其中double由参数字符串s表示的double值。
        如果s是null ，则抛出NullPointerException 。
        s中的前导和尾随空格字符s被忽略。
         */
        System.out.println(Double.valueOf(" 123 "));

        /*
        返回表示指定的double值的Double实例。
        如果不需要新的Double实例，则通常应优先使用此方法，而不是构造函数Double(double) ,不像 byte有使用缓存，Double在这里并没有使用缓存
         */
        Double d1 = Double.valueOf(0.1);
    }


    /**
     * 使用指定的字符串初始化一个新double
     */
    @Test
    public void parseDouble() {
        double d = Double.parseDouble(" 123 ");
        assert d == 123.0;
    }



    @Test
    public void isNaN() {
        /*
         * 如果指定的号码不是一个正确的数字，返回true
         */
        Double d = Double.valueOf(0.0/0.0);
        assert Double.isNaN(d);

        /*
        如果此Double值不是一个正确的数字，返回true
         */
        Double d2 = Double.valueOf(0.0/0.0);
        assert d2.isNaN();
    }


    @Test
    public void isInfinite() {
        /*
         * 如果指定的数是无限大，返回true
         */
        Double d = Double.valueOf(0.0 / 0.0);
        assert !Double.isInfinite(d);
        assert !d.isInfinite();

        Double d1 = Double.valueOf(-1.0/0.0);
        assert Double.isInfinite(d1);
        assert d1.isInfinite();
    }

    /**
     * 如果指定的数是有限浮点值，返回true,对于NaN和无穷大，返回false
     */
    @Test
    public void isFinite() {
        double d = 0.1;
        assert Double.isFinite(d);

        double d1 = 1;
        assert Double.isFinite(d1);

        //NaN
        Double d2 = Double.valueOf(0.0 / 0.0);
        assert !Double.isFinite(d2);

        //无穷大
        Double d3 = Double.valueOf(-1.0/0.0);
        assert !Double.isFinite(d3);
    }


    /**
     * 返回double值转换为byte后的值
     */
    @Test
    public void byteValue() {
        Double d = Double.valueOf(0.01);
        byte b = d.byteValue();
    }

    /**
     * 返回double值转换为short后的值
     */
    @Test
    public void shortValue() {
        Double d = Double.valueOf(1000);
        short s = d.shortValue();
    }

    /**
     * 返回double值转换为int后的值
     */
    @Test
    public void intValue() {
        Double d = Double.valueOf(123.123);
        int i = d.intValue();
    }


    /**
     * 返回double值转换为long后的值
     */
    @Test
    public void longValue() {
        Double d = Double.valueOf(123.123);
        long l = d.longValue();
    }

    /**
     * 返回double值转换为float后的值
     */
    @Test
    public void floatValue() {
        Double d = Double.valueOf(123.123);
        float f = d.floatValue();
    }

    /**
     * 返回Double对象的double值
     */
    @Test
    public void doubleValue() {
        Double d = Double.valueOf(123.123);
        double d1 = d.doubleValue();
    }


    /**
     * 返回此Double对象的哈希码。 结果是由该Double对象表示的原始double值的long整数位表示的两半的异或，完全由方法doubleToLongBits(double)产生。 也就是说，哈希码是表达式的值：
     *      (int)(v^(v>>>32))
     * 其中v的定义是：
     *      long v = Double.doubleToLongBits(this.doubleValue());
     */
    @Test
    public void hashCode1() {
        Double d = Double.valueOf(123.123);
        System.out.println(d.hashCode());

        /*
        返回double值的哈希码; 与Double.hashCode()兼容
         */
        double d1 = 123.123;
        System.out.println(Double.hashCode(d1));
    }


    /**
     * 将此对象与指定的对象进行比较。 结果为true当且仅当参数不是null且是Double对象时，该对象表示与此对象表示的double具有相同值的double 。
     * 为此目的，当且仅当方法doubleToLongBits(double)在应用于每个时返回相同的long值时，才认为两个double值相同。
     *
     * 请注意，在大多数情况下，类的两个实例Double ， d1和d2 ，d1.equals(d2)为true当且仅当d1.doubleValue() == d2.doubleValue()也为true 。
     *
     * 但是，有两个例外：
     *
     * 如果d1和d2均表示Double.NaN ，则equals方法返回true ，但Double.NaN==Double.NaN的值为false 。
     * 如果d1代表+0.0而d2代表-0.0 ，反之亦然， equal测试的值为false ，即使+0.0==-0.0的值为true 。
     * 此定义允许哈希表正常运行。
     */
    @Test
    public void equals1() {
        Double d1 = Double.valueOf(1);
        Double d2 = Double.valueOf(1);
        System.out.println(d1.equals(d2));
        System.out.println(d1 == d2);
        System.out.println(d1 == 1.0);
    }


    /**
     * 以数字方式比较两个Double对象。
     *
     * 当应用于原始double值时，此方法执行的比较有两种方式与Java语言数值比较运算符（ <, <=, ==, >=, > ）执行的比较不同：
     *
     * 此方法认为Double.NaN等于其自身且大于所有其他double值（包括Double.POSITIVE_INFINITY ）。
     *
     * 0.0d通过该方法被认为是大于-0.0d 。
     *
     * 这确保了此方法强加的Double对象的自然顺序 与equals一致
     */
    @Test
    public void compareTo() {
        Double d1 = Double.valueOf(1);
        Double d2 = Double.valueOf(1);
        System.out.println(d1.compareTo(d2));
        //Double.NaN > d1
        System.out.println(d1.compareTo(Double.NaN));
    }


}
