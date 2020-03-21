package lang;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jujun chen
 * @date 2020/02/29
 */
public class ByteTest {

    /**
     * 返回表示指定的byte的新String对象。
     */
    @Test
    public void toString1() {
        byte b = 1;
        System.out.println(Byte.toString(b));
    }


    @Test
    public void valueOf() {
        /*
          返回表示指定的byte值的Byte实例。

          如果不需要新的Byte实例，则通常应优先使用此方法，而不是构造函数Byte(byte) ，

          此方法有明显更好的空间和时间性能，因为所有字节值都被缓存。
         */
        byte b = 1;
        Byte B = Byte.valueOf(b);

        /*
        返回Byte对象，当使用第二个参数给出的基数进行解析时，该对象保存从指定的String提取的值。

        第一个参数被解释为表示由第二个参数指定的基数中的带符号byte ，

        就像该参数被赋予parseByte(java.lang.String, int)方法一样。

        结果是Byte对象，表示字符串指定的byte值。
         */
        String s1 = "123";
        Byte B1 = Byte.valueOf(s1, 10);
        Byte B2 = Byte.valueOf(s1, 8);
        assert B1 == 123;
        assert B2 == 83;
    }


    /**
     * 将字符串参数解析为第二个参数指定的基数中的带符号byte 。
     *
     * 字符串中的字符必须是数字指定基数的，（如通过确定是否Character.digit(char, int)
     * 返回一个非负的值）不同之处在于第一个字符可以是ASCII减号'-' （ '\u002D' ），以指示一个负值或ASCII加号'+' （ '\u002B' ）表示正值。
     * 返回结果byte值。
     *
     * 如果发生以下任何一种情况，则抛出类型NumberFormatException的异常：
     *      第一个参数是null或者是长度为零的字符串。
     *      基数小于Character.MIN_RADIX或大于Character.MAX_RADIX 。
     *      字符串的任何字符不是指定基数的数字，所不同的是第一个字符可以是负号'-' （ '\u002D' ）或加号'+' （ '\u002B' ），前提是所述字符串比长度1更长。
     *      字符串表示的值不是byte类型的值。
     * 参数
     *      s -所述 String含有 byte表示被解析
     *      radix - 解析 s使用的基数
     * 结果
     *      byte由指定基数中的字符串参数表示的值
     * 异常
     *      NumberFormatException - 如果字符串不包含可解析的 byte 。
     */
    @Test
    public void parseByte() {
        String s1 = "123";
        System.out.println(Byte.parseByte(s1, 10));
        //代表s1 为8进制，输出10进制
        System.out.println(Byte.parseByte(s1, 8));

        String s2 = "-1a";
        System.out.println(Byte.parseByte(s2, 16));

        //将字符串参数解析为带符号的十进制byte
        System.out.println(Byte.parseByte(s1));
    }

    /**
     * 将String解码为Byte
     */
    @Test
    public void decode() {
        //10进制
        Byte code = Byte.decode("10");
        assert code == 10;
        //16进制
        Byte code1 = Byte.decode("0x10");
        assert code1 == 16;
        //16进制
        Byte code2 = Byte.decode("#10");
        assert code2 == 16;
        //8进制
        Byte code3 = Byte.decode("010");
        assert code3 == 8;
    }

    /**
     * 返回此值 byte 。
     */
    @Test
    public void byteValue() {
        Byte B = Byte.valueOf("123");
        byte b = B.byteValue();
        byte b1 = B;
    }

    /**
     * 转换为类型 short后此对象表示的数值
     */
    @Test
    public void shortValue() {
        Byte B = Byte.valueOf("123");
        short st = B.shortValue();
    }


    /**
     * 转换为类型 int后此对象表示的数值
     */
    @Test
    public void intValue() {
        Byte B = Byte.valueOf("123");
        int st = B.intValue();
    }

    /**
     * 转换为类型 long后此对象表示的数值
     */
    @Test
    public void longValue() {
        Byte B = Byte.valueOf("123");
        long lg = B.longValue();
    }


    /**
     * 转换为类型 float后此对象表示的数值
     */
    @Test
    public void floatValue() {
        Byte B = Byte.valueOf("123");
        float ft = B.floatValue();
        System.out.println(ft);
    }


    /**
     * 转换为类型 double后此对象表示的数值
     */
    @Test
    public void doubleValue() {
        Byte B = Byte.valueOf("123");
        Double db = B.doubleValue();
    }


    @Test
    public void hashCode1() {
        Byte B = Byte.valueOf("123");
        /*
        返回此Byte的哈希码; 等于调用intValue()的结果
         */
        System.out.println(B.hashCode());

        /*
        返回byte值的哈希码; 与Byte.hashCode()兼容
         */
        byte b = 123;
        System.out.println(Byte.hashCode(b));;
    }


    /**
     * 将此对象与指定的对象进行比较。
     *
     * 当且仅当参数不是null并且是包含与此对象相同的byte值的Byte对象时，结果为true
     */
    @Test
    public void equals1() {
        Byte B1 = Byte.valueOf("123");
        Byte B2 = Byte.valueOf("123");
        Byte B3 = new Byte("123");

        System.out.println(B1.equals(B2));
        System.out.println(B1.equals(B3));
    }

    /**
     * 以数字方式比较两个 Byte对象
     *
     * 值0如果此Byte是等于参数Byte ;
     * 值小于0 ，如果这Byte在数值上小于该参数Byte ;
     * 如果此Byte在数值上大于参数Byte （带符号的比较），则值大于0
     */
    @Test
    public void compareTo() {
        Byte B1 = Byte.valueOf("123");
        Byte B2 = Byte.valueOf("12");
        assert B1.compareTo(B2) > 0;
    }

    /**
     * 以数字方式比较两个byte值。
     *
     * 返回的值与返回的值相同：
     * Byte.valueOf(x).compareTo(Byte.valueOf(y))
     *
     * 值0如果x == y ; 如果值小于0则为x < y ; 值大于0如果x > y
     */
    @Test
    public void compare() {
        Byte B1 = Byte.valueOf("123");
        Byte B2 = Byte.valueOf("12");
        assert Byte.compare(B1, B2) > 0;
    }

    /**
     * 比较两个 byte值，以数值方式将值视为无符号
     *
     * 值0如果x == y ; 如果x < y为无符号值，则小于0值; 如果x > y为无符号值，则值大于0
     */
    @Test
    public void compareUnsigned() {
        Byte B1 = Byte.valueOf("-123");
        Byte B2 = Byte.valueOf("12");
        assert Byte.compareUnsigned(B1, B2) > 0;
    }

    /**
     * 通过无符号转换将参数转换为int 。
     *
     * 在无符号转换到int ，所述的高阶24个比特int是零和低位8位都等于的比特byte参数。
     *
     * 因此，零和正byte值映射到数值相等的int值，负byte值映射到等于输入加上2的8次方的int值。
     */
    @Test
    public void toUnsignedInt() {
        Byte B1 = Byte.valueOf("-123");
        System.out.println(Byte.toUnsignedInt(B1));
        Byte B2 = Byte.valueOf("123");
        System.out.println(Byte.toUnsignedInt(B2));
    }

    /**
     * 通过无符号转换将参数转换为long 。
     *
     * 在一个无符号转换为long ，所述的高阶56个比特long是零和低位8位都等于的比特byte参数。
     *
     * 因此，零和正byte值映射到数值相等的long值，负byte值映射到等于输入加上2的8次方的long值
     */
    @Test
    public void toUnsignedLong() {

    }

}
