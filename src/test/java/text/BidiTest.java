package text;

import org.junit.Test;

import java.text.AttributedString;
import java.text.Bidi;

/**
 * @author jujun chen
 * @date 2020/05/30
 */
public class BidiTest {

    @Test
    public void constructor() {
        Bidi bidi = new Bidi("ABC", Bidi.DIRECTION_DEFAULT_LEFT_TO_RIGHT);

        AttributedString attributedString = new AttributedString("ABC");
        Bidi bidi2 = new Bidi(attributedString.getIterator());

        /*
        text- 包含要处理的文本数组
        textStart-段落开头的文本数组的索引
        embeddings- 包含段落中每个字符的嵌入值的数组。可以为null，表示没有外部的嵌入信息
        embStart- 段落开头的嵌入数组的索引
        paragraphLength- 文本和嵌入数组中段落的长度
         */
        Bidi bidi3 = new Bidi(new char[]{'A','B','C'}, 0, null, 0, 3, Bidi.DIRECTION_DEFAULT_LEFT_TO_RIGHT);
    }

    /**
     * 创建一个Bidi对象，表示当前Bidi所代表的段落中的一行文本信息
     */
    @Test
    public void createLineBidi() {
        Bidi bidi = new Bidi("ABC",Bidi.DIRECTION_DEFAULT_LEFT_TO_RIGHT);
        Bidi bidi2 = bidi.createLineBidi(1,2);
        System.out.println(bidi2.getLength());
        System.out.println(bidi.getLength());
    }

    @Test
    public void isMixed() {
        //true
        Bidi bidi = new Bidi("ABC", Bidi.DIRECTION_RIGHT_TO_LEFT);
        System.out.println(bidi.isMixed());

        //false
        Bidi bidi2 = new Bidi("ABC", Bidi.DIRECTION_LEFT_TO_RIGHT);
        System.out.println(bidi2.isMixed());

        //false
        Bidi bidi3 = new Bidi("ABC", Bidi.DIRECTION_DEFAULT_RIGHT_TO_LEFT);
        System.out.println(bidi3.isMixed());

        //false
        Bidi bidi4 = new Bidi("ABC", Bidi.DIRECTION_DEFAULT_LEFT_TO_RIGHT);
        System.out.println(bidi4.isMixed());
    }

    /**
     * 文本是否是从左到右的顺序
     */
    @Test
    public void isLeftToRight() {
        Bidi bidi = new Bidi("ABC",Bidi.DIRECTION_LEFT_TO_RIGHT);
        System.out.println(bidi.isLeftToRight());

        Bidi bidi2 = new Bidi("ABC",Bidi.DIRECTION_DEFAULT_LEFT_TO_RIGHT);
        System.out.println(bidi2.isLeftToRight());
    }

    /**
     * 文本是否是从右到左的顺序
     */
    @Test
    public void isRightToLeft() {

    }

    /**
     * 返回文中文本的长度
     */
    @Test
    public void getLength() {
        Bidi bidi = new Bidi("ABC",Bidi.DIRECTION_LEFT_TO_RIGHT);
        System.out.println(bidi.getLength());
    }

    /**
     * 如果基本方向是从左到右，则返回true
     */
    @Test
    public void baseIsLeftToRight() {
        Bidi bidi = new Bidi("ABC",Bidi.DIRECTION_LEFT_TO_RIGHT);
        System.out.println(bidi.baseIsLeftToRight());
    }

    /**
     * 返回基准级别，从左到右为0，从右到左为1
     */
    @Test
    public void getBaseLevel() {
        Bidi bidi = new Bidi("ABC",Bidi.DIRECTION_LEFT_TO_RIGHT);
        System.out.println(bidi.getBaseLevel());
    }
}
