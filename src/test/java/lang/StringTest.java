package lang;

import org.junit.Test;

/**
 * @author jujun chen
 * @date 2020/04/14
 */
public class StringTest {
    
    @Test
    public void String() {
        String abc = "abc";
        String string = new String(abc.getBytes());
        System.out.println(string);

        char[] chars = {'a','b','c'};
        //offset 为子串的第一个索引，count指定子count的长度
        String string1 = new String(chars,1,1);
        System.out.println(string1);


    }

}
