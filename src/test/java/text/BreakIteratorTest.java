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

    @Test
    public void following() {
        breakIterator.following(1);
        System.out.println(breakIterator.current());
    }
}
