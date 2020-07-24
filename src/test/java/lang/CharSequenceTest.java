package lang;

import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @author jujun chen
 * @date 2020/03/22
 */
public class CharSequenceTest {

    /**
     * 返回此字符序列的长度。
     * <p>
     * 长度是序列中16位char的数量。
     */
    @Test
    public void length() {
        CharSequence charSequence = "abc";
        System.out.println(charSequence.length());
    }

    /**
     * 返回指定索引处的char值。 索引范围为0到length() - 1 。
     * <p>
     * 序列的第一个char值在索引0处，下一个在索引1处，依此类推，就像数组索引一样。
     * <p>
     * 如果索引指定的char值为代理点，则返回代理值。
     */
    @Test
    public void charAt() {
        CharSequence charSequence = "abc";
        System.out.println(charSequence.charAt(1));
    }

    /**
     * 返回CharSequence ，它是此序列的子序列。
     * <p>
     * 该子序列与所述启动char指定索引处值和与所述结束char在索引值end - 1。
     * <p>
     * 返回的长度为end - start ，因此，如果start == end ，则返回一个空的序列。
     * <p>
     * 参数
     * start - 起始索引，包括
     * end - 最终索引，独家
     * 结果
     * 指定的子序列
     */
    @Test
    public void subSequence() {
        CharSequence charSequence = "abc";
        System.out.println(charSequence.subSequence(0, 1));
        System.out.println(charSequence.subSequence(1, 1));
    }

    /**
     * 返回IntStream流
     */
    @Test
    public void chars() {
        CharSequence charSequence = "abc";
        System.out.println(charSequence.chars().findFirst().equals("a"));
        ;
    }

    /**
     * 返回此序列中的代码点值流
     */
    @Test
    public void codePoints() {
        CharSequence charSequence = "abc";
        //代码点97 98 99
        IntStream intStream = charSequence.codePoints();
        System.out.println(intStream.findFirst());
    }

    /**
     * CharSequence字典顺序比较两个CharSequence实例。
     * <p>
     * 如果第一个序列按字典顺序小于，等于或大于第二个序列，则返回负值，零或正值。
     * <p>
     * CharSequence的字典顺序定义如下。
     * 考虑长度为len的CharSequence cs为char值序列， cs [0]到cs [len-1] 。
     * 假设k是每个序列的相应char值不同的最低索引。
     * 序列的词典排序通过char值cs1 [k]与cs2 [k]的数值比较来确定。
     * 如果没有这样的索引k ，则较短的序列在字典上被认为小于另一个。 如果序列具有相同的长度，则认为序列在词典上相等。
     * <p>
     * 参数
     * cs1 - 第一个 CharSequence
     * cs2 - 第二个 CharSequence
     * 结果
     * 如果两个CharSequence相等，则值0 ; 如果第一个CharSequence字典顺序小于第二个， CharSequence负整数; 如果第一个CharSequence字典顺序大于第二个，
     * CharSequence正整数。
     */
    @Test
    public void compare() {
        CharSequence cs1 = "abc";
        CharSequence cs2 = "abcd";

        System.out.println(CharSequence.compare(cs1, cs2));

        CharSequence cs3 = "aaa";
        CharSequence cs4 = "aab";
        System.out.println(CharSequence.compare(cs3, cs4));
    }
}
