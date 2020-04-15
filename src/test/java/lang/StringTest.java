package lang;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author jujun chen
 * @date 2020/04/14
 */
public class StringTest {
    
    @Test
    public void String() throws UnsupportedEncodingException {
        String abc = "abc";
        String string = new String(abc.getBytes());
        System.out.println(string);

        char[] chars = {'a','b','c'};
        //offset 为子串的第一个索引，count指定子count的长度
        String string1 = new String(chars,1,1);
        System.out.println(string1);

        //代码点
        String string2 = new String(new int[]{97},0,1);
        System.out.println(string2);

        String string3 = new String(abc.getBytes(),"UTF-8");
        System.out.println(string3);

        //StringBuffer
        StringBuffer stringBuffer = new StringBuffer("abc");
        String string4 = new String(stringBuffer);
        System.out.println(string4);
        //修改stringBuffer，原来的字符串不变
        stringBuffer.append("d");
        System.out.println(string4);

        //StringBuilder
    }

    /**
     * 返回字符串的长度
     */
    @Test
    public void length() {
        System.out.println("abc".length());
    }

    /**
     * 当length()的长度为0时返回true
     */
    @Test
    public void isEmpty() {
        assert "".isEmpty();
    }

    /**
     * 返回指定索引处的char值
     */
    @Test
    public void charAt() {
        char ch = "abc".charAt(1);
        System.out.println(ch);
    }

    /**
     * 返回指定索引处的代码点
     */
    @Test
    public void codePointAt() {
        int codePoint = "abc".codePointAt(0);
        System.out.println(codePoint);
    }

    /**
     * 返回指定索引之前的字符代码点
     * index从1到length
     */
    @Test
    public void codePointBefore() {
        int codePoint  = "abc".codePointBefore(1);
        System.out.println(codePoint);
    }

    /**
     * 返回此String的指定文本范围内的Unicode代码点数
     * 参数
     * beginIndex - 文本范围的第一个 char的索引
     * endIndex - 文本范围的最后 char之后的索引
     */
    @Test
    public void codePointCount() {
        int codePointCount ="abc".codePointCount(0,3);
        System.out.println(codePointCount);
    }


    /**
     * 返回从指定的索引开始偏移指定的代码点值后，所在的索引值
     * 参数
     * index - 要偏移的索引
     * codePointOffset - 代码点中的偏移量，负数向左偏移
     */
    @Test
    public void offsetByCodePoints() {
        //从b开始向左偏移1位，即索引为0
        int offsetByCodePoints = "abc".offsetByCodePoints(1,-1);
        System.out.println(offsetByCodePoints);
    }

    /**
     * 将此字符串中的字符复制到目标字符数组中
     * 参数
     * srcBegin - 要复制的字符串中第一个字符的索引。
     * srcEnd - 要复制的字符串中的最后一个字符后面的索引。
     * dst - 目标数组。
     * dstBegin - 目标数组中的起始偏移量。
     */
    @Test
    public void getChars() {
        char[] dst = new char[10];
        "abc".getChars(0,1,dst,1);
        assert 'a' == dst[1];
    }

    /**
     * 如果字符串与指定的StringBuffer字符串序列相同，则返回true
     */
    @Test
    public void contentEquals() {
        StringBuffer stringBuffer = new StringBuffer("abc");
        assert "abc".contentEquals(stringBuffer);

        assert "abc".contentEquals("abc");
    }


    /**
     * 忽略大小写，比较字符串是相同，忽略语言环境，在不同语言环境下，结果可能不同
     */
    @Test
    public void equalsIgnoreCase() {
        assert "ABC".equalsIgnoreCase("abc");
    }
}
