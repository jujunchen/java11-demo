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

    /**
     * 按字典顺序比较两个字符串
     * 此字符串对象排在参数字符串之前，返回负数
     * 此字符串对象排在参数字符串之后，返回正数
     * 相等，返回零
     */
    @Test
    public void compareTo() {
        System.out.println("abc".compareTo("abd"));
        System.out.println("abc".compareTo("ab"));
        //如果长度相同,根据不同字符的字段顺序比较
        System.out.println("abcd".compareTo("abdc"));
        System.out.println("aBc".compareTo("abc"));

        //忽略大小写
        System.out.println("aBc".compareToIgnoreCase("abc"));
    }

    /**
     * 将此字符串对象的子字符串与参数的字符串进行比较，如果子字符串相同，则结果为true，否则为false。
     * 要比较的此String对象的子字符串从索引toffset开始，长度为len ,要比较的其他子串从索引ooffset开始，长度为len
     * 参数
     * toffset - 此字符串 toffset区域的起始偏移量。
     * other - 字符串参数。
     * ooffset - 字符串参数 ooffset区域的起始偏移量。
     * len - 要比较的字符数。
     */
    @Test
    public void regionMatches() {
        System.out.println("abc".regionMatches(1,"abc",1,2));
        //比较忽略大小写
        System.out.println("Abc".regionMatches(true,1,"abc",1,2));
    }

    /**
     * 测试从指定索引开始的子字符串是否已指定前缀开头
     */
    @Test
    public void startsWith() {
        System.out.println("abc".startsWith("ab",0));
        System.out.println("abc".startsWith("ab"));
    }

    /**
     * 测试此字符串是否已指定的后缀结尾
     */
    @Test
    public void endsWith() {
        System.out.println("abc".endsWith("bc"));
    }

    /**
     * 返回字符串中第一次出现指定字符的索引，如果未出现该字符返回-1
     */
    @Test
    public void indexOf() {
        System.out.println("abc".indexOf('a'));
        System.out.println("abc".indexOf("d"));
        System.out.println("abc".indexOf(97));
        System.out.println("abc".indexOf("ab"));

        System.out.println("abc".indexOf('c',1));
        System.out.println("abc".indexOf("c",1));

        //fromIndex 为负数，表示从0开始
        System.out.println("abc".indexOf('c', -2));

        //fromIndex大于等于字符串长度，则fromIndex为字符串长度,返回-1
        System.out.println("abc".indexOf('c',3));
    }

    /**
     * 返回指定字符最后一次出现的字符串中的索引,向后搜索
     */
    @Test
    public void lastIndexOf() {
        System.out.println("aba".lastIndexOf('a'));
        System.out.println("aba".lastIndexOf("a"));

        //从fromIndex指定的索引处开始搜索，如果是负数，返回-1
        System.out.println("abc".lastIndexOf('c',1));
        System.out.println("abc".lastIndexOf("c",1));
    }

    /**
     * 返回子字符串，子字符串以指定索引处的字符开头，并延伸到此字符串的末尾。
     */
    @Test
    public void substring() {
        assert "abc".substring(1).equals("bc");
        assert "abc".substring(3).equals("");

        //返回一个字符串，该字符串是此字符串的子字符串。
        // 子字符串从指定的beginIndex开始，并扩展到索引endIndex - 1处的字符。
        // 因此子串的长度是endIndex-beginIndex
        assert "hamburger".substring(4, 8).equals("urge");

        //返回作为此序列的子序列的字符序列
        CharSequence charSequence = "hamburger".subSequence(4, 8);
    }

}
