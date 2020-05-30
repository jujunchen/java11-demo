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
}
