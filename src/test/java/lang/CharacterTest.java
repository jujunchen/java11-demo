package lang;

import org.junit.Test;

/**
 * @author jujun chen
 * @date 2020/02/29
 */
public class CharacterTest {

    @Test
    public void methodTest() {
        //是否标题属性
        System.out.println(Character.isTitleCase('L'));

        System.out.println(Character.getType(97));
        //翻转字符的字节顺序
//        System.out.println(Character.reverseBytes('2'));
        System.out.println(Character.getDirectionality('A'));
        System.out.println(Character.isWhitespace(' '));
        System.out.println(Character.getNumericValue('a'));
        char ch  = 97;
        System.out.println(ch);
        //字符强转成int 就为ascii码，codePoint可以理解为是ascii码
        System.out.println((int)'哈');
        System.out.println(Character.codePointAt(new char[]{'a'}, 0));
        System.out.println(Character.toChars(97));
        System.out.println(Character.digit('A', 2));
        System.out.println(Character.forDigit(-1,10));
    }



}
