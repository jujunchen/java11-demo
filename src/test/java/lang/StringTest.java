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
        int codePoint = "abc".codePointAt(1);
        System.out.println(codePoint);
    }


}
