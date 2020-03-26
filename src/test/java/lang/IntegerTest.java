package lang;

import org.junit.Test;

/**
 * https://blog.csdn.net/yvonne8_5/article/details/50956016
 * @author jujun chen
 * @date 2020/03/26
 */
public class IntegerTest {


    /**
     * 返回第二个参数指定的基数中第一个参数的字符串表示形式
     */
    @Test
    public void toString1() {
        System.out.println(Integer.toString(0x21,10));
        System.out.println(Integer.toString(-0x21,10));
    }

    /**
     * 返回第一个参数的字符串表示形式，作为第二个参数指定的基数中的无符号整数值
     */
    @Test
    public void toUnsignedString() {
        System.out.println(Integer.toUnsignedString(0x21,10));
        System.out.println(Integer.toUnsignedString(-0x21,10));
    }

    /**
     * 返回整数参数的字符串表示形式，作为基数为16进制无符号整数。
     *
     * 如果参数为负，则无符号整数值是参数加2的32次方 ; 否则，它等于参数。
     *
     * 此值将转换为十六进制（基数为16）的ASCII数字字符串，没有额外的前导0 。
     *
     * 可以通过调用Integer.parseUnsignedInt(s, 16)从返回的字符串s恢复参数的值。
     *
     * 如果无符号幅度为零，则由单个零字符'0' （ '\u0030' ）表示; 否则，无符号幅度表示的第一个字符将不是零字符
     */
    @Test
    public void toHexString() {
        System.out.println(Integer.toHexString(33));
        System.out.println(Integer.toHexString(-33));
        System.out.println(Integer.parseUnsignedInt("21",16));
    }

    /**
     * 返回整数参数的字符串表示形式，作为基数为8进制无符号整数。
     *
     * 如果参数为负，则无符号整数值是参数加2的32次方 ; 否则，它等于参数。
     *
     * 此值将转换为八进制（基数为8）的ASCII数字字符串，没有额外的前导0 。
     *
     * 可以通过调用Integer.parseUnsignedInt(s, 8)从返回的字符串s恢复参数的值。
     *
     * 如果无符号幅度为零，则由单个零字符'0'（ '\u0030' ）表示; 否则，无符号幅度表示的第一个字符将不是零字符。
     */
    @Test
    public void toOctalString() {
        System.out.println(Integer.toOctalString(33));
        System.out.println(Integer.parseUnsignedInt("41",8));
    }

    /**
     * 返回整数参数的字符串表示形式，作为基于2进制中的无符号整数。
     *
     * 如果参数为负，则无符号整数值是参数加2的32次方  ; 否则它等于参数。
     *
     * 此值将转换为二进制（基数2）中的ASCII数字字符串，没有额外的前导0 。
     *
     * 可以通过调用Integer.parseUnsignedInt(s, 2)从返回的字符串s恢复参数的值。
     *
     * 如果无符号幅度为零，则由单个零字符'0' （ '\u0030' ）表示; 否则，无符号幅度表示的第一个字符将不是零字符。
     *
     * 字符'0' （ '\u0030' ）和'1' （ '\u0031' ）用作二进制数字。
     */
    @Test
    public void toBinaryString() {
        System.out.println(Integer.toBinaryString(33));
        System.out.println(Integer.toBinaryString(-33));
    }
    

    @Test
    public void parseInt() {
        /*
         * 将字符串参数解析为第二个参数指定基数的有符号整数。
         *
         * 字符串中的字符必须全部是指定基数的数字（由Character.digit(char, int)是否返回非负值确定），但第一个字符可能是ASCII减号'-' （ '\u002D' ）以指示负值或ASCII加号'+' （ '\u002B' ）表示正值。
         *
         * 返回结果整数值。
         */
        System.out.println(Integer.parseInt("21",16));

        /*
         * 将字符串参数解析为带符号的十进制整数。字符串中的字符必须全部为十进制数字
         */
        System.out.println(Integer.parseInt("21"));
        //NumberFormatException
//        System.out.println(Integer.parseInt("0x21"));


        /*
        解析CharSequence参数作为有符号int指定radix ，在指定的开始beginIndex并延伸到endIndex - 1
        参数
            s -所述 CharSequence含有 int表示被解析
            beginIndex - 起始索引，包括。
            endIndex - 结束索引，不包括。
            radix - 解析 s使用的基数。
        结果
            签名的 int由指定基数中的子 int表示。
         */
        System.out.println(Integer.parseInt("abc",1,3,16));

    }

    /**
     * 解析为无符号整数
     * 用法同parseInt
     */
    @Test
    public void parseUnsignedInt() {
        
    }


    @Test
    public void valueOf() {
        /*
         * 使用第二个参数给出的基数进行解析时，返回一个Integer对象
         *
         * 此方法等同于：
         *
         * new Integer(Integer.parseInt(s, radix))
         */
        Integer integer = Integer.valueOf("21",16);

        /*
        返回一个Integer，指定的值String 。

        该参数被解析为表示带符号的十进制整数
         */
        Integer integer1 = Integer.valueOf("33");

        Integer integer2 = Integer.valueOf(33);
    }

    /**
     * 此对象的哈希码值，等于原始 int由该表示值 Integer对象
     */
    @Test
    public void hashCode1() {
        Integer integer2 = Integer.valueOf(33);
        System.out.println(integer2.hashCode());
    }

    /**
     * 确定具有指定名称的系统属性的整数值。
     * 第一个参数被视为系统属性的名称。 可以通过System.getProperty(java.lang.String)方法访问系统属性。
     * 然后，使用decode支持的语法将此属性的字符串值解释为整数值，并返回表示此值的Integer对象。
     *
     * 如果没有具有指定名称的属性，如果指定的名称为空或null ，或者属性没有正确的数字格式，则返回null 。
     *
     * 换句话说，此方法返回一个等于值的Integer对象：
     *
     * getInteger(nm, null)
     * 参数
     *      nm - 属性名称。
     * 结果
     *      Integer类型的值。
     */
    @Test
    public void getInteger() {
        Integer integer = Integer.getInteger("classpath", 123);
        System.out.println(integer);
    }

    /**
     * 将String解码为Integer 。
     *
     * 接受以下语法给出的十进制，十六进制和八进制数：
     * DecodableString:
     * Signopt DecimalNumeral
     * Signopt 0x HexDigits
     * Signopt 0X HexDigits
     * Signopt # HexDigits
     * Signopt 0 OctalDigits
     * Sign:
     * -
     * +
     * DecimalNumeral ， HexDigits和OctalDigits在The Java™ Language Specification的 3.10.1节中定义 ，但数字之间不接受下划线。
     * 可选符号和/或基数说明符（“ 0x ”，“ 0X ”，“ # ”或前导零）后面的字符序列由Integer.parseInt方法用指示的基数（10,16或8）进行解析。
     * 此字符序列必须表示正值或将抛出NumberFormatException 。 如果指定的String第一个字符是减号，则结果为否定。 String中不允许使用空格字符
     */
    @Test
    public void decode() {
        System.out.println(Integer.decode("0x21"));
    }


    /**
     * 比较两个 int值，以数值方式将值视为无符号。
     * 参数
     *      x - 第一个 int进行比较
     *      y - 第二个 int进行比较
     * 结果
     *      值0如果x == y ; 如果x < y为无符号值，则值小于0 ; 如果x > y为无符号值，则值大于0
     */
    @Test
    public void compareUnsigned() {
        System.out.println(Integer.compareUnsigned(-10,10));
    }


    /**
     * 返回将第一个参数除以第二个参数的无符号商，其中每个参数和结果都被解释为无符号值。
     *
     * 注意，在二进制补码算法中，如果两个操作数被认为是有符号的或两者都是无符号的，
     *
     * 则加，减和乘法的其他三个基本算术运算是逐位相同的。 因此，未提供单独的addUnsigned等方法。
     *
     * 参数
     *      dividend - 要划分的值
     *      divisor - 进行分割的值
     * 结果
     *      第一个参数除以第二个参数的无符号商
     */
    @Test
    public void divideUnsigned() {
        //转换为无符号的long类型的数值，再相除
        System.out.println(Integer.divideUnsigned(10,2));
        System.out.println(Integer.divideUnsigned(10,-2));
    }


    /**
     * 返回将第一个参数除以第二个参数的无符号余数，其中每个参数和结果都被解释为无符号值。
     * 参数
     *      dividend - 要划分的值
     *      divisor - 进行分割的价值
     * 结果
     *      返回将第一个参数除以第二个参数的无符号余数
     */
    @Test
    public void remainderUnsigned() {
        System.out.println(Integer.remainderUnsigned(10,2));
        System.out.println(Integer.remainderUnsigned(3,10));
    }

    @Test
    public void lowestOneBit() {
        //负数补码 = 原码 取反 +1
        //所以负数最低位的1之前的所以二进制数会因为 a & -a = 0，全部消去，只留下最低位的1
        System.out.println(Integer.lowestOneBit(1213));
    }

    //https://www.jianshu.com/p/2c1be41f6e59
    /**
     * 返回无符号整型i的最高非零位前面的0的个数
     */
    @Test
    public void numberOfLeadingZeros() {
        
    }

}
