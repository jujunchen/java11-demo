package text;

import org.junit.Test;

import java.text.BreakIterator;
import java.util.Locale;

/**
 * @author jujun chen
 * @date 2020/06/01
 */
public class BreakIteratorTest {

    String examine = "你好，中国。欢迎来到中国。";
    //句子边界
    BreakIterator breakIterator = BreakIterator.getSentenceInstance(Locale.CHINESE);

    @Test
    public void getLineInstance() {

        //字符边界
//        BreakIterator breakIterator = BreakIterator.getCharacterInstance(Locale.CHINESE);
        //单词边界
//        BreakIterator breakIterator = BreakIterator.getWordInstance(Locale.CHINESE);
        //行边界
//        BreakIterator breakIterator = BreakIterator.getLineInstance(Locale.CHINESE);

        breakIterator.setText(examine);

        //返回第一个文本边界
        int start = breakIterator.first();
        for (int end = breakIterator.next(); end != BreakIterator.DONE; start = end, end = breakIterator.next()) {
            System.out.println(examine.substring(start, end));
        }
    }

    /**
     * 返回current+n个边界的字符索引
     */
    @Test
    public void next() {
        breakIterator.setText(examine);

        System.out.println(breakIterator.current());
        //相当于next(1)
        System.out.println(breakIterator.next());

        System.out.println(breakIterator.next(1));
    }

    /**
     * 指定偏移量后的第一个文本边界
     */
    @Test
    public void following() {
        breakIterator.setText(examine);

        breakIterator.following(1);
        //第一个边界是0，偏移后的第一个边界是6
        System.out.println(breakIterator.current());
    }

    /**
     * 指定偏移量之前的最后一个文本边界
     */
    @Test
    public void preceding() {
        breakIterator.setText(examine);

        breakIterator.preceding(1);

        //偏移之前的最后一个边界是0
        System.out.println(breakIterator.current());
    }


    /**
     * 指定的偏移量处是文本边界返回true,否则返回false
     */
    @Test
    public void isBoundary() {
        breakIterator.setText(examine);

        //false
        System.out.println(breakIterator.isBoundary(1));
        //true
        System.out.println(breakIterator.isBoundary(6));
    }


    /**
     * 返回所有语言环境的数组
     */
    @Test
    public void getAvailableLocales() {
        Locale[] locales = BreakIterator.getAvailableLocales();

    }
}
