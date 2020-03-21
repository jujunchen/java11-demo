package lang;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author jujun chen
 * @date 2020/02/29
 */
public class CharacterTest {

    /**
     * 返回表示指定的char值的Character实例。
     *
     * 如果不需要新的Character实例，则通常应优先使用此方法，而不是构造函数Character(char)
     *
     * 因为此方法可能通过缓存频繁请求的值来显着提高空间和时间性能。
     *
     * 此方法将始终缓存'\u0000'至'\u007F'范围内的值，并且可以缓存此范围之外的其他值
     */
    @Test
    public void valueOf() {
        Character character = Character.valueOf('A');
        Character character1 = 'A';
    }


    /**
     * 返回此对象表示的原始值 char
     */
    @Test
    public void charValue() {
        Character character = Character.valueOf('A');
        char a = character.charValue();
    }

    /**
     * 返回此Character的哈希码; 等于调用charValue()的结果
     */
    @Test
    public void hashCode1() {
        Character character = Character.valueOf('A');
        int hashcode = character.hashCode();
        char a = character.charValue();
        assert hashcode == a;
    }


    @Test
    public void toString1() {
        /*
        返回表示此Character值的String对象。 其结果是长度为1的串，其唯一分量是原始char由该表示值Character对象
         */
        Character character = Character.valueOf('A');
        System.out.println(character.toString());

        /*
        返回表示指定的char的String对象。 结果是一个长度为1的字符串，仅由指定的char
         */
        System.out.println(Character.toString('A'));

        /*
        返回表示指定字符（Unicode代码点）的String对象。 结果是一个长度为1或2的字符串，仅由指定的codePoint
         */
        //字符强转成int 就为ascii码，codePoint可以理解为是ascii码
        int codePoint = (int)'哈';
        System.out.println(codePoint);
        System.out.println(Character.toString(codePoint));
    }


    /**
     * 确定指定的代码点是否有效
     *
     * true如果指定的代码点值介于{@link Character#MIN_CODE_POINT} 和 {@link Character#MAX_CODE_POINT}之间; 否则为false
     */
    @Test
    public void isValidCodePoint() {
        int codePoint = (int)'哈';
        System.out.println(Character.isValidCodePoint(codePoint));
    }

    /**
     * 确定指定的字符（Unicode代码点）是否在Basic Multilingual Plane (BMP)中。这些代码点可以使用单个char表示。
     *
     * U+0000 to U+FFFF有时被称为基本多语言平面（BMP）
     *
     * 代码点大于U + FFFF的Characters称为补充字符
     *
     * char值表示基本多语言平面（BMP）代码点，包括代理代码点或UTF-16编码的代码单元。
     *
     * int值表示所有Unicode代码点，包括补充代码点。
     *
     * int的较低（最低有效）21位用于表示Unicode代码点，而较高（最高有效）11位必须为零
     *
     * true如果指定的代码点介于{@link Character#MIN_VALUE} 和 {@link Character#MAX_VALUE} 之间; 否则为false
     */
    @Test
    public void isBmpCodePoint() {
        int codePoint = (int)'芏';
        System.out.println(Character.isBmpCodePoint(codePoint));
        System.out.println(Character.isBmpCodePoint(65535));
        System.out.println(Character.isBmpCodePoint(65536));
    }

    /**
     * 确定指定的字符（Unicode代码点）是否在 supplementary character（补充代码点）范围内
     */
    @Test
    public void isSupplementaryCodePoint() {
        System.out.println(Character.isSupplementaryCodePoint(65533));
        System.out.println(Character.isSupplementaryCodePoint(65536));
    }


    /**
     * 确定给定的char值是否为Unicode high-surrogate code unit （也称为前导代理代码单元 ）。
     * 这些值本身不代表字符，但在UTF-16编码中用于表示supplementary characters
     *
     * true如果char值介于{@link Character#MIN_HIGH_SURROGATE} 和 {@link Character#MAX_HIGH_SURROGATE}之间;
     *
     * 否则为false
     */
    @Test
    public void isHighSurrogate() {
        System.out.println(Character.isHighSurrogate('\uD800'));
    }

    /**
     * 确定给定的char值是否为Unicode low-surrogate code unit （也称为trailing-surrogate代码单元 ）
     *
     * 这些值本身不代表字符，但在UTF-16编码中以supplementary characters的表示形式使用。
     *
     * true如果char值介于{@link Character#MIN_LOW_SURROGATE} 和 {@link Character#MAX_LOW_SURROGATE}之间;
     *
     * 否则为false
     *
     */
    @Test
    public void isLowSurrogate() {
        System.out.println(Character.isLowSurrogate('\uDC00'));
    }

    /**
     * 确定给定的char值是否为Unicode 代理代码单元 。
     *
     * 这些值本身不代表字符，但在UTF-16编码中用于表示supplementary characters 。
     *
     * char值是代理代码单元，当且仅当它是low-surrogate code unit或high-surrogate code unit时
     *
     * true如果char值介于{@link Character#MIN_SURROGATE} 和 {@link Character#MAX_SURROGATE} 之间; 否则为false
     */
    @Test
    public void isSurrogate() {
        System.out.println(Character.isLowSurrogate('\u1FFF'));
    }


    /**
     * 确定指定的char值对是否为有效Unicode surrogate pair
     * 此方法等效于表达式：
     *  isHighSurrogate(high) && isLowSurrogate(low)
     */
    @Test
    public void isSurrogatePair() {
        System.out.println(Character.isSurrogatePair('\uDBFF','\uDC00'));
    }

    /**
     * 确定表示指定字符（Unicode代码点）所需的char值的数量。
     *
     * 如果指定的字符等于或大于0x10000，则该方法返回2.否则，该方法返回1。
     *
     * 此方法不会将指定的字符验证为有效的Unicode代码点。 如有必要，调用者必须使用isValidCodePoint验证字符值。
     *
     * 参数
     *      codePoint - 要测试的字符（Unicode代码点）。
     * 结果
     *      2如果角色是有效的补充角色; 否则为1。
     */
    @Test
    public void charCount() {
        System.out.println(Character.isValidCodePoint('\uDC00'));
        System.out.println(Character.charCount('\uDC00'));
    }

    /**
     * 将指定的代理单元转换为其补充代码点值。 此方法不验证指定的代理项对。
     *
     * 如有必要，使用isSurrogatePair对其进行验证。
     */
    @Test
    public void toCodePoint() {
        System.out.println(Character.toCodePoint('\uDBFF','\uDC00'));
        System.out.println(Character.toString(1113088));
    }


    /**
     * 返回CharSequence的给定索引处的代码点。
     * 如果char给定索引处的值CharSequence处于高代理项范围，下列指数小于所述长度CharSequence
     * ，并且char以下索引处的值是在低代理项范围内，则所述辅助返回与此代理项对相对应的代码点。
     * 否则，返回给定索引处的char值。
     */
    @Test
    public void codePointAt() {
        System.out.println(Character.codePointAt("abc", 1));

        //数组 char
        System.out.println(Character.codePointAt(new char[]{'a'}, 0));
    }
    
    
    @Test
    public void codePointBefore() {
        /*
        返回CharSequence的给定索引之前的代码点。

        如果char在值(index - 1)在CharSequence处于低代理项范围， (index - 2)不为负，并且char在值(index - 2)在CharSequence处于高代理项范围内，则对应于该代理对的增补代码点是回。

        否则，返回char值(index - 1) 。
         */
        System.out.println(Character.codePointBefore("abc", 1));

        /**
         * 返回char数组的给定索引之前的代码点,其他相同
         */
        System.out.println(Character.codePointBefore(new char[]{'a','b','c'}, 1));


        /*
        返回char数组的给定索引之前的代码点，其中只能使用index大于或等于start数组元素，其他相同
         */
        System.out.println(Character.codePointBefore(new char[]{'a','b','c'}, 3, 0));
    }


    /**
     * 返回用于表示UTF-16编码中的字符的前导代理代码单元
     *
     * 如果指定的字符不是补充代码点 ，则返回未指定的char
     *
     * 如果isSupplementaryCodePoint(x)是true
     *
     * 则isHighSurrogate (highSurrogate(x))和toCodePoint (highSurrogate(x), lowSurrogate (x)) == x也总是true 。
     *
     * 参数
     *      codePoint - 补充字符（Unicode代码点）
     */
    @Test
    public void highSurrogate() {
        System.out.println(Character.isSupplementaryCodePoint(65536));
        System.out.println(Character.highSurrogate(65536));
    }


    /**
     * 如果指定的字符不是supplementary character ，则返回未指定的char 。
     * 如果isSupplementaryCodePoint(x)是true ，那么isLowSurrogate (lowSurrogate(x))和toCodePoint ( highSurrogate (x),
     * lowSurrogate(x)) == x也总是true 。
     *
     * 参数
     *      codePoint - 补充字符（Unicode代码点）
     * 结果
     *      低位代理代码单元，用于表示UTF-16编码中的字符
     */
    @Test
    public void lowSurrogate() {
        System.out.println(Character.isSupplementaryCodePoint(65536));
        System.out.println(Character.lowSurrogate(65536));
        System.out.println(Character.isLowSurrogate (Character.lowSurrogate(65536)));
    }


    @Test
    public void toChars() {
        /*
         * 将指定字符（Unicode代码点）转换为其UTF-16表示形式。 如果指定的代码点是BMP（基本多语言平面或平面0）值，则相同的值存储在dst[dstIndex] ，并返回1。
         * 如果指定的代码点是补充字符，则其代理值存储在dst[dstIndex] （high-surrogate）和dst[dstIndex+1] （low-surrogate）中，并返回2。
         *
         * 参数
         *      codePoint - 要转换的字符（Unicode代码点）。
         *      dst - char数组 ，其中 codePoint的UTF-16值被存储。
         *      dstIndex - 存储转换值的 dst数组的起始索引。
         * 结果
         *      如果代码点是BMP代码点，则为1;如果代码点是补充代码点，则为2。
         */
        char[] chars = new char[10];
        System.out.println(Character.toChars(65536, chars, 0));

        /*
        将指定字符（Unicode代码点）转换为存储在char数组中的UTF-16表示形式。
        如果指定的代码点是BMP（基本多语言平面或平面0）值，则生成的char数组具有与codePoint相同的值。
        如果指定的代码点是补充代码点，则生成的char数组具有相应的代理项对。
        参数
            codePoint - Unicode代码点
        结果
            具有 codePoint的UTF-16表示的 char数组。
         */
        System.out.println(Arrays.toString(Character.toChars(65536)));
        System.out.println(Arrays.toString(Character.toChars(33423)));
    }
    
    
    @Test
    public void codePointCount() {
        /*
        返回指定char序列的文本范围内的Unicode代码点数。
        文本范围开始在指定的beginIndex ，并延伸到char在索引endIndex - 1。
        因此，文本范围的长度（在chars中）是endIndex-beginIndex。
        文本范围内的未配对代理计为每个代码点。
        参数
            seq - 字符序列
            beginIndex - 文本范围的第一个 char的索引。
            endIndex - 文本范围的最后 char之后的索引。
        结果
            指定文本范围内的Unicode代码点数
         */
        System.out.println(Character.codePointCount("abcd", 0, 2));

        /*
        返回char数组参数的子数组中Unicode代码点的数量。
        offset参数是子数组的第一个char的索引，而count参数指定以char为单位的子数组的长度。
        子数组中未配对的替代物每个计为一个代码点。
        参数
            a - char数组
            offset - 给定 char数组中第一个 char的索引
            count - char数组的长度
        结果
            指定子数组中的Unicode代码点数
         */
        System.out.println(Character.codePointCount(new char[]{'a','b','c'}, 0 , 3));
    }



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

        System.out.println(Character.codePointAt(new char[]{'a'}, 0));
        System.out.println(Character.toChars(97));
        System.out.println(Character.digit('A', 2));
        System.out.println(Character.forDigit(-1,10));
    }



}
