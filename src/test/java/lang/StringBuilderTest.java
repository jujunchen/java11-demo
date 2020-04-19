package lang;

import org.junit.Test;

/**
 * @author jujun chen
 * @date 2020/04/18
 */
public class StringBuilderTest {

    /**
     * 比较两个StringBuilder的实例
     */
    @Test
    public void compareTo() {
        StringBuilder stringBuilder1 = new StringBuilder("abc");
        StringBuilder stringBuilder2 = new StringBuilder("abc");
        assert stringBuilder1.compareTo(stringBuilder2) == 0;
    }
    
    @Test
    public void append() {
        Person person = new Person();
        person.name = "Java";
        //追加Object对象的字符串形式
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(person);

        //追加字符
        stringBuilder.append(",Go");

        //将StringBuffer追加到此
        stringBuilder.append(new StringBuffer(",Python"));

        //追加指定的字符序列
        CharSequence charSequence = " Good";
        stringBuilder.append(charSequence);

        //将指定的字符追加到此，从start索引开始，到end索引结束，包括头，不包括尾
        CharSequence charSequence2 = " Study";
        stringBuilder.append(charSequence2, 0,6);

        //其他的append方法
        //将char数组的字符追加到此序列

        //从offset索引开始，追加len个字符数量到此序列

        //将boolean追加到序列中

        //将char追加到序列中

        //将int追加到序列中

        //long参数追加到序列中

        //float参数追加到序列中

        //double参数追加到序列中


        System.out.println(stringBuilder);
    }
}
