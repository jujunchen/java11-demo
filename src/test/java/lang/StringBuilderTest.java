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

    /**
     * 将代码点表示的字符追加到此序列
     */
    @Test
    public void appendCodePoint() {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println(stringBuilder.appendCodePoint(97));
    }

    /**
     * 删除子序列，从start开始到 end结束，包括起始，不包括结束
     */
    @Test
    public void delete() {
        StringBuilder stringBuilder = new StringBuilder("abc");
        System.out.println(stringBuilder.delete(1,2));
        System.out.println(stringBuilder.delete(2,2));
    }

    /**
     * 删除指定索引处的字符
     */
    @Test
    public void deleteCharAt() {
        StringBuilder stringBuilder = new StringBuilder("abc");
        System.out.println(stringBuilder.deleteCharAt(1));
    }

    @Test
    public void replace() {
        //从start开始到end结束(不包括)，使用str替换
        StringBuilder stringBuilder = new StringBuilder("abc");
        System.out.println(stringBuilder.replace(0,2,"a"));
    }

    @Test
    public void insert() {
        StringBuilder stringBuilder = new StringBuilder("abc");
        /*
        insert​(int index, char[] str, int offset, int len)
        参数
        index - 插入子阵列的位置。
        str - char阵列。
        offset - 要插入的子阵列中的第一个 char的索引。
        len - 要插入的子阵列中的 chars的数量。
         */
        System.out.println(stringBuilder.insert(0,new char[]{'c','d','e','f'},1,3));

        //将Object的字符串形式插入序列中
        //offset 插入的索引位置
        Person person = new Person();
        person.name = "Java";
        System.out.println(stringBuilder.insert(0,person));

        //将字符串插入序列中
        //offset 需要插入的索引位置
        System.out.println(stringBuilder.insert(0, "xxx"));

        //其他插入方法
        //insert​(int offset, char[] str)
        //insert​(int dstOffset, CharSequence s)
        //insert​(int dstOffset, CharSequence s, int start, int end)
        //insert​(int offset, boolean b)
        //insert​(int offset, char c)
        //insert​(int offset, int i)
        //insert​(int offset, long l)
        //insert​(int offset, float f)
        //insert​(int offset, double d)
    }

    @Test
    public void indexOf() {
        StringBuilder stringBuilder = new StringBuilder("abcb");
        //返回指定子字符串第一次出现的字符串中的索引
        System.out.println(stringBuilder.indexOf("b"));

        //从指定的索引处开始，返回指定子字符串第一次出现的字符串中的索引
        //indexOf​(String str, int fromIndex)
    }
    
    @Test
    public void lastIndexOf() {
        //返回指定子字符串最后一次出现的字符串中的索引
        //lastIndexOf​(String str)

        //返回指定子字符串最后一次出现的字符串中的索引，从指定索引开始向后搜索
        //lastIndexOf​(String str, int fromIndex)
    }


    /**
     * 反向字符序列
     */
    @Test
    public void reverse() {
        StringBuilder stringBuilder = new StringBuilder("abc");
        System.out.println(stringBuilder.reverse());
    }

    /**
     * 确保容量至少等于指定的最小值。 如果当前容量小于参数，则分配具有更大容量的新内部阵列。 新容量是更大的：
     * minimumCapacity参数。
     * 旧容量的两倍，加上2 。
     * 如果minimumCapacity参数为非正数，则此方法不执行任何操作，只返回。 请注意，对此对象的后续操作可以将实际容量降低到此处请求的容量以下。
     * 参数
     * minimumCapacity - 所需的最小容量。
     */
    @Test
    public void ensureCapacity() {
        
    }

    /**
     * 尝试减少用于字符序列的存储空间。
     * 如果缓冲区大于保持其当前字符序列所需的缓冲区，则可以调整其大小以使空间效率更高。
     * 调用此方法可能（但不是必须）影响后续调用capacity()方法返回的值。
     */
    @Test
    public void trimToSize() {
        
    }

    /**
     * 设置字符序列的长度。
     * 序列更改为新的字符序列，其长度由参数指定
     * 如果newLength参数小于当前长度，则长度将更改为指定的长度
     * 如果newLength参数大于或等于当前长度，则会附加足够的空字符（ '\u0000' ），以使length成为newLength参数
     */
    @Test
    public void setLength() {
        StringBuilder stringBuilder = new StringBuilder("abc");
        stringBuilder.setLength(2);
        System.out.println(stringBuilder);
    }

    /**
     * 返回指定索引处的char值
     */
    @Test
    public void charAt() {

    }


    /**
     * 返回此序列中的索引，该索引从给定的index偏移codePointOffset代码点。
     * index和codePointOffset给出的文本范围内的未配对代理计为每个代码点。
     * 参数
     * index - 要偏移的索引
     * codePointOffset - 代码点中的偏移量
     */
    @Test
    public void offsetByCodePoints() {
        
    }

    /**
     * 将字符从该序列复制到目标字符数组dst 。 要复制的第一个字符是索引srcBegin ; 要复制的最后一个字符位于索引srcEnd-1 。 要复制的字符总数为srcEnd-srcBegin 。
     * 字符被复制到dst的子dst从索引dstBegin开始并以索引结束：
     *    dstbegin + (srcEnd-srcBegin) - 1
     * 参数
     * srcBegin - 以此偏移量开始复制。
     * srcEnd - 停止在此偏移处复制。
     * dst - 要将数据复制到的数组。
     * dstBegin - 偏移到 dst 。
     */
    @Test
    public void getChars() {
        
    }

    /**
     * 返回一个新的String ，其中包含此字符序列中当前包含的字符的子序列。 子字符串从指定的索引开始并延伸到此序列的末尾。
     * 参数
     * start - 起始索引，包括在内。
     */
    @Test
    public void substring() {
        
    }

    /**
     * 返回int 流
     */
    @Test
    public void chars() {
        
    }

    /**
     * 返回此序列中的代码点值流
     */
    @Test
    public void codePoints() {
        
    }

}
