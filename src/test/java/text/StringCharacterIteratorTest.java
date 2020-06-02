package text;

import org.junit.Test;

import java.text.StringCharacterIterator;

/**
 * @author jujun chen
 * @date 2020/06/02
 */
public class StringCharacterIteratorTest {

    @Test
    public void test1() {
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator("ABC");
        //A
        System.out.println(stringCharacterIterator.current());

        StringCharacterIterator stringCharacterIterator1 = new StringCharacterIterator("ABC",1);
        //B
        System.out.println(stringCharacterIterator1.current());

        StringCharacterIterator stringCharacterIterator2 = new StringCharacterIterator("ABC",2,3,2);
        //C
        System.out.println(stringCharacterIterator2.current());
    }

    /**
     * 给该迭代器赋值新文本
     */
    @Test
    public void setText() {
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator("ABC");
        stringCharacterIterator.setText("DEF");
        System.out.println(stringCharacterIterator.current());
    }


    @Test
    public void first() {
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator("ABC");
        /*
         * 文本中的第一个字符
         */
        System.out.println(stringCharacterIterator.first());
        /*
        文本中的最后一个字符
         */
        System.out.println(stringCharacterIterator.last());

        /*
        指定位置的字符
         */
        System.out.println(stringCharacterIterator.setIndex(2));

        /*
         * 下一个位置的字符
         */
        System.out.println(stringCharacterIterator.first());
        System.out.println(stringCharacterIterator.next());

        /*
        上一个位置的字符
         */
        System.out.println(stringCharacterIterator.previous());

        /*
         * 文本的开始位置
         */
        System.out.println(stringCharacterIterator.getBeginIndex());

        /*
        文本的结束位置
         */
        System.out.println(stringCharacterIterator.getEndIndex());

        /*
        目前的位置
         */
        //0
        System.out.println(stringCharacterIterator.getIndex());
        //往后移动
        System.out.println(stringCharacterIterator.next());
        //1
        System.out.println(stringCharacterIterator.getIndex());
    }
}
