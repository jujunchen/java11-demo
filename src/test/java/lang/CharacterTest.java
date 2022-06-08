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
     * <p>
     * 如果不需要新的Character实例，则通常应优先使用此方法，而不是构造函数Character(char)
     * <p>
     * 因为此方法可能通过缓存频繁请求的值来显着提高空间和时间性能。
     * <p>
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
        assert hashcode == a; //true
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

        //Unicode 和ASCII相关编码介绍：https://m.php.cn/faq/483053.html
        //Code Point介绍：http://www.unicode.org/glossary/#code_point
        /*
        返回表示指定字符（Unicode代码点）的String对象。 结果是一个长度为1或2的字符串，仅由指定的codePoint
         */
        int codePoint = (int) '哈';
        System.out.println(codePoint); //21704 16进制为54C8，unicode为\u54c8
        System.out.println(Character.toString(codePoint)); //哈
    }


    /**
     * 确定指定的代码点是否有效
     * <p>
     * true如果指定的代码点值介于{@link Character#MIN_CODE_POINT} 和 {@link Character#MAX_CODE_POINT}之间; 否则为false
     */
    @Test
    public void isValidCodePoint() {
        int codePoint = (int) '哈';
        System.out.println(Character.isValidCodePoint(codePoint));
    }

    /**
     * 确定指定的字符（Unicode代码点）是否在Basic Multilingual Plane (BMP)中。这些代码点可以使用单个char表示。
     * <p>
     * U+0000 to U+FFFF有时被称为基本多语言平面（BMP）
     * <p>
     * 代码点大于U + FFFF的Characters称为补充字符
     * <p>
     * char值表示基本多语言平面（BMP）代码点，包括代理代码点或UTF-16编码的代码单元。
     * <p>
     * int值表示所有Unicode代码点，包括补充代码点。
     * <p>
     * int的较低（最低有效）21位用于表示Unicode代码点，而较高（最高有效）11位必须为零
     * <p>
     * true如果指定的代码点介于{@link Character#MIN_VALUE} 和 {@link Character#MAX_VALUE} 之间; 否则为false
     */
    @Test
    public void isBmpCodePoint() {
        int codePoint = (int) '芏';
        System.out.println(codePoint);
        System.out.println(Character.isBmpCodePoint(codePoint));
        System.out.println(Character.isBmpCodePoint(65535));
        System.out.println(Character.isBmpCodePoint(65536));
        /**
         * 33423
         * true
         * true
         * false
         */
    }

    /**
     * 确定指定的字符（Unicode代码点）是否在 supplementary character（补充代码点）范围内
     */
    @Test
    public void isSupplementaryCodePoint() {
        System.out.println(Character.isSupplementaryCodePoint(65533));
        System.out.println(Character.isSupplementaryCodePoint(65536));

        /**
         * false
         * true
         */
    }


    /**
     * 确定给定的char值是否为Unicode high-surrogate code unit （也称为前导代理代码单元 ）。
     * 这些值本身不代表字符，但在UTF-16编码中用于表示supplementary characters
     * <p>
     * true如果char值介于{@link Character#MIN_HIGH_SURROGATE} 和 {@link Character#MAX_HIGH_SURROGATE}之间;
     * <p>
     * 否则为false
     */
    @Test
    public void isHighSurrogate() {
        System.out.println(Character.isHighSurrogate('\uD800')); //true
    }

    /**
     * 确定给定的char值是否为Unicode low-surrogate code unit （也称为trailing-surrogate代码单元 ）
     * <p>
     * 这些值本身不代表字符，但在UTF-16编码中以supplementary characters的表示形式使用。
     * <p>
     * true如果char值介于{@link Character#MIN_LOW_SURROGATE} 和 {@link Character#MAX_LOW_SURROGATE}之间;
     * <p>
     * 否则为false
     */
    @Test
    public void isLowSurrogate() {
        System.out.println(Character.isLowSurrogate('\uDC00')); //true
    }

    /**
     * 确定给定的char值是否为Unicode 代理代码单元 。
     * <p>
     * 这些值本身不代表字符，但在UTF-16编码中用于表示supplementary characters 。
     * <p>
     * char值是代理代码单元，当且仅当它是low-surrogate code unit或high-surrogate code unit时
     * <p>
     * true如果char值介于{@link Character#MIN_SURROGATE} 和 {@link Character#MAX_SURROGATE} 之间; 否则为false
     */
    @Test
    public void isSurrogate() {
        System.out.println(Character.isSurrogate('\u1FFF')); //false
    }


    /**
     * 确定指定的char值对是否为有效Unicode surrogate pair
     * 此方法等效于表达式：
     * isHighSurrogate(high) && isLowSurrogate(low)
     */
    @Test
    public void isSurrogatePair() {
        System.out.println(Character.isSurrogatePair('\uDBFF', '\uDC00')); //true
    }

    /**
     * 确定表示指定字符（Unicode代码点）所需的char值的数量。
     * <p>
     * 如果指定的字符等于或大于0x10000，则该方法返回2.否则，该方法返回1。
     * <p>
     * 此方法不会将指定的字符验证为有效的Unicode代码点。 如有必要，调用者必须使用isValidCodePoint验证字符值。
     * <p>
     * 参数
     * codePoint - 要测试的字符（Unicode代码点）。
     * 结果
     * 2如果角色是有效的补充角色; 否则为1。
     */
    @Test
    public void charCount() {
        System.out.println(Character.isValidCodePoint('\uDC00'));
        System.out.println(Character.charCount('\uDC00'));
        /**
         * true
         * 1
         */
    }

    /**
     * 将指定的代理单元转换为其补充代码点值。 此方法不验证指定的代理项对。
     * <p>
     * 如有必要，使用isSurrogatePair对其进行验证。
     */
    @Test
    public void toCodePoint() {
        System.out.println(Character.toCodePoint('\uDBFF', '\uDC00'));
        System.out.println(Character.toString(1113088));
        /**
         * 1113088
         * 􏰀
         */
    }


    /**
     * 返回CharSequence的给定索引处的代码点。
     * 如果char给定索引处的值CharSequence处于高代理项范围，下列指数小于所述长度CharSequence
     * ，并且char以下索引处的值是在低代理项范围内，则所述辅助返回与此代理项对相对应的代码点。
     * 否则，返回给定索引处的char值。
     */
    @Test
    public void codePointAt() {
        System.out.println(Character.codePointAt("abc", 0));
        System.out.println(Character.codePointAt("abc", 2));
        //数组 char
        System.out.println(Character.codePointAt(new char[]{'a'}, 0));
        /**
         * 97
         * 99
         * 97
         */
    }


    @Test
    public void codePointBefore() {
        /*
        返回CharSequence的给定索引之前的代码点。

        如果char在值(index - 1)在CharSequence处于低代理项范围， (index - 2)不为负，并且char在值(index - 2)
        在CharSequence处于高代理项范围内，则对应于该代理对的增补代码点是回。

        否则，返回char值(index - 1) 。
         */
        System.out.println(Character.codePointBefore("abc", 1));

        /**
         * 返回char数组的给定索引之前的代码点,其他相同
         */
        System.out.println(Character.codePointBefore(new char[]{'a', 'b', 'c'}, 1));


        /*
        返回char数组的给定索引之前的代码点，其中只能使用index大于或等于start数组元素，其他相同
        参形：
        a - char数组 index – 应返回的代码点之后的索引 start – char数组中第一个数组元素的索引
        返回值：
        给定索引之前的 Unicode 代码点值
         */
        System.out.println(Character.codePointBefore(new char[]{'a', 'b', 'c'}, 2, 0));
    }


    /**
     * 返回用于表示UTF-16编码中的字符的前导代理代码单元
     * <p>
     * 如果指定的字符不是补充代码点 ，则返回未指定的char
     * <p>
     * 如果isSupplementaryCodePoint(x)是true
     * <p>
     * 则isHighSurrogate (highSurrogate(x))和toCodePoint (highSurrogate(x), lowSurrogate (x)) == x也总是true 。
     * <p>
     * 参数
     * codePoint - 补充字符（Unicode代码点）
     */
    @Test
    public void highSurrogate() {
        System.out.println(Character.isSupplementaryCodePoint(65536));
        System.out.println(Character.highSurrogate(65536));
        /**
         * true
         * ?
         */
    }


    /**
     * 如果指定的字符不是supplementary character ，则返回未指定的char 。
     * 如果isSupplementaryCodePoint(x)是true ，那么isLowSurrogate (lowSurrogate(x))和toCodePoint ( highSurrogate (x),
     * lowSurrogate(x)) == x也总是true 。
     * <p>
     * 参数
     * codePoint - 补充字符（Unicode代码点）
     * 结果
     * 低位代理代码单元，用于表示UTF-16编码中的字符
     */
    @Test
    public void lowSurrogate() {
        System.out.println(Character.isSupplementaryCodePoint(65536));
        System.out.println(Character.lowSurrogate(65536));
        System.out.println(Character.isLowSurrogate(Character.lowSurrogate(65536)));
        /**
         * true
         * ?
         * true
         */
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

        /**
         * 2
         * [?, ?]
         * [芏]
         */
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
        System.out.println(Character.codePointCount(new char[]{'a', 'b', 'c'}, 0, 3));

        /**
         * 2
         * 3
         */
    }


    @Test
    public void offsetByCodePoints() {
        /*
        返回给定char序列中的索引，该索引从给定的index偏移codePointOffset代码点。
        index和codePointOffset给出的文本范围内的未配对代理计为每个代码点。
        参数
            seq - 字符序列
            index - 要偏移的索引
            codePointOffset - 代码点中的偏移量
        结果
            char序列中的索引
         */
        System.out.println(Character.offsetByCodePoints("abcd", 0, 1));

        /*
        返回给定的索引char子阵是从给定的偏移index由codePointOffset代码点。
        start和count参数指定char数组的子数组。 由index和codePointOffset给出的文本范围内的未配对代理计为每个代码点。
        参数
            a - char数组
            start - 子阵列的第一个 char的索引
            count - char阵列的长度
            index - 要偏移的索引
            codePointOffset - 代码点中的偏移量
        结果
            数组中的索引
         */
        System.out.println(Character.offsetByCodePoints(new char[]{'a', 'b', 'c', 'd'}, 0, 4, 0, 2));

        /**
         * 1
         * 2
         */
    }


    @Test
    public void isLowerCase() {
        /*
         * 确定指定的字符是否为小写字符
         */
        System.out.println(Character.isLowerCase('A'));

        /*
        确定指定的字符（Unicode代码点）是否为小写字符。
         */
        System.out.println(Character.isLowerCase(97));

        /**
         * false
         * true
         */
    }

    @Test
    public void isUpperCase() {
        /*
        确定指定的字符（Unicode代码点）是否为大写字符
         */
        //用法同isLowerCase
    }


    @Test
    public void isTitleCase() {
        /*
        确定指定的字符是否为标题字符。
        字符是否为标题字符，如果它的一般类别类型，通过提供Character.getType(ch) ，是TITLECASE_LETTER 。
         */
        System.out.println(Character.getType('J'));
        System.out.println(Character.isTitleCase('Z'));
        /**
         * 1
         * false
         */
    }


    @Test
    public void isDigit() {
        /*
        确定指定的字符是否为数字
         */
        System.out.println(Character.isDigit('1'));


        /*
         * 确定指定的字符（Unicode代码点）是否为数字
         */
        System.out.println(Character.isDigit(97));
        /**
         * true
         * false
         */
    }


    @Test
    public void isDefined() {
        /*
        确定是否为Unicode中定义的字符。
        如果至少满足下列条件之一，则定义字符：
        它在UnicodeData文件中有一个条目。
        它具有UnicodeData文件定义的范围中的值。
         */
        System.out.println(Character.isDefined('a'));

        /*
        确定是否在Unicode中定义了字符（Unicode代码点）
         */
        System.out.println(Character.isDefined(97));
    }


    @Test
    public void isLetter() {
        /*
        确定指定的字符是否为letter

        如果字符的一般类别类型（由Character.getType(ch)提供）是以下任何一种字符，则该字符被视为字母：
        UPPERCASE_LETTER
        LOWERCASE_LETTER
        TITLECASE_LETTER
        MODIFIER_LETTER
        OTHER_LETTER
         */
        System.out.println(Character.isLetter('A'));
        System.out.println(Character.isLetter('陈'));

        /*
        确定指定的字符（Unicode代码点）是否为字母
         */
        System.out.println(Character.isLetter(97));
    }


    @Test
    public void isLetterOrDigit() {
        /*
        确定指定的字符是Letter或者数字
         */
        System.out.println(Character.isLetterOrDigit('A'));
        System.out.println(Character.isLetterOrDigit('1'));
        System.out.println(Character.isLetterOrDigit('?'));
        System.out.println(Character.isLetterOrDigit('陈'));

        /*
        确定指定的字符（Unicode代码点）是字母还是数字
         */
        System.out.println(Character.isLetterOrDigit(97));
        /**
         * true
         * true
         * false
         * true
         * true
         */
    }

    /**
     * 注释格式为：“Unicode规范中的种类”
     *     //“Cn”
     *     public static final byte UNASSIGNED = 0;
     *     //“Lu”——大写字母
     *     public static final byte UPPERCASE_LETTER = 1;
     *     //“Ll”——小写字母
     *     public static final byte LOWERCASE_LETTER = 2;
     *     //“Lt”
     *     public static final byte TITLECASE_LETTER = 3;
     *     //“Lm”
     *     public static final byte MODIFIER_LETTER = 4;
     *     //“Lo”——各种文字，汉字属于此类
     *     public static final byte OTHER_LETTER = 5;
     *     //“Mn”——该类字符不会占用一个空格的空间，而是作用在之前或之后的字符上。如删除线、下划线等
     *     public static final byte NON_SPACING_MARK = 6;
     *     //“Me”——闭合字符，如' ⃟'、' ⃠'
     *     public static final byte ENCLOSING_MARK = 7;
     *     //“Mc”——
     *     public static final byte COMBINING_SPACING_MARK = 8;
     *     //“Nd”——数字字符，如阿拉伯数字
     *     public static final byte DECIMAL_DIGIT_NUMBER = 9;
     *     //“Nl”——字母数字，如罗马数字
     *     public static final byte LETTER_NUMBER = 10;
     *     //“No”——其他的特殊数字，如：'①'、'⑴'、'⒈'、'㈠'
     *     public static final byte OTHER_NUMBER = 11;
     *     //“Zs”
     *     public static final byte SPACE_SEPARATOR = 12;
     *     //“Zl”
     *     public static final byte LINE_SEPARATOR = 13;
     *     //“Zp”
     *     public static final byte PARAGRAPH_SEPARATOR = 14;
     *     //“Cc”
     *     public static final byte CONTROL = 15;
     *     //“Cf”
     *     public static final byte FORMAT = 16;
     *     //“Co”
     *     public static final byte PRIVATE_USE = 18;
     *     //“Cs”
     *     public static final byte SURROGATE = 19;
     *     //“Pd”——连接符，如'-'
     *     public static final byte DASH_PUNCTUATION = 20;
     *     //“Ps”——成对标点符号的开始符号，如'('、'【'、'{'、'《'
     *     public static final byte START_PUNCTUATION = 21;
     *     //“Pe”——成对标点符号的结束符号，如')'、'】'、'}'、'》'
     *     public static final byte END_PUNCTUATION = 22;
     *     //“Pc”
     *     public static final byte CONNECTOR_PUNCTUATION = 23;
     *     //“Po”——其他标点符号，如'!'、'?'、'！'、'？'
     *     public static final byte OTHER_PUNCTUATION = 24;
     *     //“Sm”——数学符号，如'+'、'='、'>'
     *     public static final byte MATH_SYMBOL = 25;
     *     //“Sc”——货币符号，如'$'、'￥'
     *     public static final byte CURRENCY_SYMBOL = 26;
     *     //“Sk”——修饰符，如'^'
     *     public static final byte MODIFIER_SYMBOL = 27;
     *     //“So”——其他符号，如'⒜'
     *     public static final byte OTHER_SYMBOL = 28;
     *     //“Pi”——引用符号的开始符号，如'“'、'‘'
     *     public static final byte INITIAL_QUOTE_PUNCTUATION = 29;
     *     //“Pf”——引用符号的结束符号，如'”'、'’'
     *     public static final byte FINAL_QUOTE_PUNCTUATION = 30;
     */


    @Test
    public void isAlphabetic() {
        /*
        确定指定的字符（Unicode代码点）是否为字母。
        如果字符的一般类别类型（由getType(codePoint)提供）是以下任何一种，则该字符被视为字母字符：

        UPPERCASE_LETTER
        LOWERCASE_LETTER
        TITLECASE_LETTER
        MODIFIER_LETTER
        OTHER_LETTER
        LETTER_NUMBER
        或者它具有由Unicode标准定义的贡献属性Other_Alphabetic。
         */
        System.out.println(Character.isAlphabetic(123));
        System.out.println(Character.toString(123));//{
        System.out.println(Character.isAlphabetic(97));//A
        System.out.println(Character.isAlphabetic(21704));//哈
        /**
         * false
         * {
         * true
         * true
         */
    }


    /**
     * 确定指定的字符（Unicode代码点）是否为Unicode标准定义的CJKV（中文，日文，韩文和越南文）表意文字
     */
    @Test
    public void isIdeographic() {
        System.out.println(Character.isIdeographic('哈'));
        System.out.println(Character.isIdeographic('a'));
        /**
         * true
         * false
         */
    }


    /**
     * 确定指定的字符是否允许作为Java标识符中的第一个字符。
     * 当且仅当满足下列条件之一时，字符才可以作为Java标识符：
     * <p>
     * isLetter(ch)返回true
     * getType(ch)返回LETTER_NUMBER
     * ch是货币符号（例如'$' ）
     * ch是连接标点字符（例如'_' ）。
     */
    @Test
    public void isJavaIdentifierStart() {
        System.out.println(Character.isJavaIdentifierStart('?'));
        System.out.println(Character.isJavaIdentifierStart('_'));

        System.out.println(Character.isJavaIdentifierStart(97));

        /**
         * false
         * true
         * true
         */
    }


    /**
     * 确定指定的字符是否可以作为Java标识符的一部分，而不是第一个字符。
     * 如果满足以下任何条件，则字符可能是Java标识符的一部分：
     */
    @Test
    public void isJavaIdentifierPart() {
        System.out.println(Character.isJavaIdentifierPart('?'));

        System.out.println(Character.isJavaIdentifierPart(97));
        /**
         * false
         * true
         */
    }


    /**
     * 确定指定的字符是否允许作为Unicode标识符中的第一个字符。
     * 当且仅当满足下列条件之一时，字符才可以启动Unicode标识符：
     * <p>
     * isLetter(ch)返回true
     * getType(ch)返回LETTER_NUMBER 。
     */
    @Test
    public void isUnicodeIdentifierStart() {
        System.out.println(Character.isUnicodeIdentifierStart('哈'));
        System.out.println(Character.isUnicodeIdentifierStart('_'));

        //代码点
        System.out.println(Character.isUnicodeIdentifierStart(97));

        /**
         * true
         * false
         * true
         */
    }


    /**
     * 确定指定的字符是否可能是Unicode标识符的一部分，而不是第一个字符
     */
    @Test
    public void isUnicodeIdentifierPart() {
        //支持，字符，和代码点
        System.out.println(Character.isUnicodeIdentifierPart('哈'));
        System.out.println(Character.isUnicodeIdentifierPart('-'));
        System.out.println(Character.isUnicodeIdentifierPart(97));
        /**
         * true
         * false
         * true
         */
    }


    /**
     * 确定指定的字符是否应被视为Java标识符或Unicode标识符中的可忽略字符。
     * Java标识符或Unicode标识符中可以忽略以下Unicode字符：
     * <p>
     * ISO控制字符不是空格
     * '\u0000'至'\u0008'
     * '\u000E'至'\u001B'
     * '\u007F'至'\u009F'
     * 具有FORMAT常规类别值的所有字符
     * <p>
     * 结果
     * true如果字符是可忽略的控制字符，可能是Java或Unicode标识符的一部分; 否则为false
     */
    @Test
    public void isIdentifierIgnorable() {
        System.out.println(Character.isIdentifierIgnorable('\u0000'));  //true
        //也支持代码点
    }


    @Test
    public void toLowerCase() {
        /*
        使用UnicodeData文件中的大小写映射信息将字符参数转换为小写。
        请注意，对于某些字符范围， Character.isLowerCase(Character.toLowerCase(ch))并不总是返回true ，特别是那些符号或表意符号。

        通常，应使用String.toLowerCase()将字符映射为小写。

        String案例映射方法比Character案例映射方法有几个好处。

        String案例映射方法可以执行区域设置敏感的映射，上下文相关的映射和1：M字符映射，而Character案例映射方法则不能。

        注意：此方法无法处理supplementary characters 。 要支持所有Unicode字符（包括增补字符），请使用toLowerCase(int)方法。

        参数
                ch - 要转换的字符。
        结果
                字符的小写，如果有的话; 否则，角色本身。
         */
        System.out.println(Character.toLowerCase('A'));

        System.out.println(Character.isLowerCase(Character.toLowerCase('_')));

        //也支持使用代码点

        /**
         * a
         * false
         */
    }


    @Test
    public void toUpperCase() {
        /*
        使用UnicodeData文件中的大小写映射信息将字符参数转换为大写。
        请注意，对于某些字符范围， Character.isUpperCase(Character.toUpperCase(ch))并不总是返回true ，特别是那些符号或表意符号。

        通常，应使用String.toUpperCase()将字符映射为大写。

        String案例映射方法比Character案例映射方法有几个好处。

        String案例映射方法可以执行区域设置敏感的映射，上下文相关的映射和1：M字符映射，而Character案例映射方法则不能。

        注意：此方法无法处理supplementary characters 。 要支持所有Unicode字符（包括增补字符），请使用toUpperCase(int)方法。

        参数
            ch - 要转换的字符。
        结果
            字符的大写，如果有的话; 否则，角色本身。
         */
        System.out.println(Character.toUpperCase('a'));

        //也支持使用代码点
    }


    @Test
    public void toTitleCase() {
        /*
        使用UnicodeData文件中的大小写映射信息将字符参数转换为标题。 如果一个字符没有明确的标题映射，并且根据UnicodeData本身不是一个标题字符串，那么大写映射将作为等效的标题映射返回。
        如果char参数已经是标题char ，则将返回相同的char值。
        请注意，对于某些字符范围， Character.isTitleCase(Character.toTitleCase(ch))并不总是返回true 。

        注意：此方法无法处理supplementary characters 。 要支持所有Unicode字符（包括增补字符），请使用toTitleCase(int)方法。

        参数
            ch - 要转换的字符。
        结果
            相当于该字符的标题词，如果有的话; 否则，角色本身。
         */
        System.out.println(Character.toTitleCase('a'));
        System.out.println(Character.isTitleCase(Character.toTitleCase('a')));

        //支持使用代码点
    }


    @Test
    public void digit() {
        /*
        返回指定基数中字符ch的数值。
        如果基数不在范围MIN_RADIX â‰¤ radix â‰¤ MAX_RADIX或者价值ch不是指定基数的有效数字， -1返回。 如果至少满足下列条件之一，则字符是有效数字：

        方法isDigit是字符的true ，并且字符的Unicode十进制数值（或其单字符分解）小于指定的基数。 在这种情况下，返回十进制数值。
        该字符是大写拉丁字母'A'至'Z' ，其代码小于radix + 'A' - 10 。 在这种情况下，返回ch - 'A' + 10 。
        该字符是小写拉丁字母'a'到'z' ，其代码小于radix + 'a' - 10 。 在这种情况下，返回ch - 'a' + 10 。
        该字符是全'\uFF21'写拉丁字母A（ '\uFF21' ）到Z（ '\uFF3A' ）之一，其代码小于radix + '\uFF21' - 10 。 在这种情况下，返回ch - '\uFF21' + 10 。
        该字符是全宽小写拉丁字母a（ '\uFF41' ）到z（ '\uFF5A' ）之一，其代码小于radix + '\uFF41' - 10 。 在这种情况下，返回ch - '\uFF41' + 10 。
         */
        System.out.println(Character.digit('A', 16)); //10
        System.out.println(Character.digit('A', 10)); //-1

        //也支持使用代码点
    }


    /**
     * 返回指定的Unicode字符表示的int值。 例如，字符'\u216C' （罗马数字50）将返回值为50的int。
     * 大写字母AZ（ '\u0041'到'\u005A' ），小写字母（ '\u0061'到'\u007A' ）和全宽变体（ '\uFF21'到'\uFF3A'和'\uFF41'到'\uFF5A' ）形式的数值从10到35
     * '\uFF5A' 。这与Unicode规范无关，不会为这些char值分配数值。
     * <p>
     * 如果字符没有数字值，则返回-1。 如果字符的数值不能表示为非负整数（例如，小数值），则返回-2。
     * <p>
     * 注意：此方法无法处理supplementary characters 。 要支持所有Unicode字符（包括增补字符），请使用getNumericValue(int)方法。
     * <p>
     * 参数
     * ch - 要转换的字符。
     * 结果
     * 字符的数值，作为非负int值; -2如果字符具有数值但该值不能表示为非负int值; 如果字符没有数字值，则返回-1。
     */
    @Test
    public void getNumericValue() {
        System.out.println(Character.getNumericValue('A')); //10
        //支持使用代码点
    }


    /**
     * 确定指定的字符是否为Unicode空格字符。 当且仅当Unicode标准将字符指定为空格字符时，才将字符视为空格字符。 如果角色的常规类别类型是以下任何一种，则此方法返回true：
     * SPACE_SEPARATOR
     * LINE_SEPARATOR
     * PARAGRAPH_SEPARATOR
     * 注意：此方法无法处理supplementary characters 。 要支持所有Unicode字符（包括增补字符），请使用isSpaceChar(int)方法。
     * <p>
     * 参数
     * ch - 要测试的角色。
     * 结果
     * true如果角色是空格字符; 否则为false 。
     */
    @Test
    public void isSpaceChar() {
        System.out.println(Character.isSpaceChar(' '));
        System.out.println(Character.isSpaceChar('\ue00f'));
        //支持使用代码点

        /**
         * true
         * false
         */
    }


    /**
     * 根据Java确定指定的字符是否为空格。 当且仅当它满足以下条件之一时，字符才是Java空白字符：
     * 它是Unicode空格字符（ SPACE_SEPARATOR ， LINE_SEPARATOR ，或PARAGRAPH_SEPARATOR ），但不也是非打破空间（ '\u00A0' ， '\u2007' ，
     * '\u202F' ）。
     * 它是'\t' ，U + 0009 HORIZONTAL '\t' 。
     * 它是'\n' ，U + 000A LINE FEED。
     * 它是'\u000B' ，U + 000B VERTICAL '\u000B' 。
     * 它是'\f' ，U + 000C FORM FEED。
     * 它是'\r' ，U + 000D '\r' RETURN。
     * 它是'\u001C' ，U + 001C FILE SEPARATOR。
     * 它是'\u001D' ，U + 001D GROUP SEPARATOR。
     * 它是'\u001E' ，U + 001E RECORD SEPARATOR。
     * 它是'\u001F' ，U + 001F UNIT SEPARATOR。
     */
    @Test
    public void isWhitespace() {
        System.out.println(Character.isWhitespace(' '));
    }


    /**
     * 确定指定的字符是否为ISO控制字符。
     * <p>
     * 一个字符被认为如果其代码是在范围为ISO控制字符'\u0000'通过'\u001F'或在范围'\u007F'通过'\u009F' 。
     * <p>
     * 注意：此方法无法处理supplementary characters 。
     * <p>
     * 要支持所有Unicode字符（包括增补字符），请使用{@link Character#isISOControl(int)}方法。
     * <p>
     * 参数
     * ch - 要测试的角色。
     * 结果
     * true如果字符是ISO控制字符; 否则为false
     */
    @Test
    public void isISOControl() {
        System.out.println(Character.isISOControl('\u001F')); //true
        //支持使用代码点
    }


    /**
     * 返回表示字符常规类别的值。
     * 注意：此方法无法处理supplementary characters 。
     * <p>
     * 要支持所有Unicode字符（包括增补字符），请使用{@link Character#getType(int)}方法。
     * <p>
     * 参数
     * ch - 要测试的角色。
     * 结果
     * 类型为 int的值，表示字符的常规类别
     */
    @Test
    public void getType() {
        System.out.println(Character.getType('a'));
        //支持使用代码点
    }


    /**
     * 确定指定基数中特定数字的字符表示形式。
     * <p>
     * 如果值radix不是有效基数，或者值digit不是指定基数中的有效数字，则返回空字符（ '\u0000' ）。
     * 该radix参数是有效的，如果它是大于或等于MIN_RADIX且小于或等于MAX_RADIX 。
     * 如果0 <= digit < radix ，则digit参数有效。
     * <p>
     * 如果该数字小于10，则返回'0' + digit 。 否则，返回值'a' + digit - 10 。
     * <p>
     * 参数
     * digit - 要转换为字符的数字。
     * radix - 基数。
     * 结果
     * 指定基数中指定数字的 char表示形式。
     */
    @Test
    public void forDigit() {
        //10进制
        System.out.println(Character.forDigit(1, 10));
        //16进制
        System.out.println(Character.forDigit(11, 16));
        /**
         * 1
         * b
         */
    }


    /**
     * 返回给定字符的Unicode方向性属性。
     * <p>
     * 字符方向性用于计算文本的视觉排序。 未定义char值的方向性值为DIRECTIONALITY_UNDEFINED 。
     * 注意：此方法无法处理supplementary characters 。
     * 要支持所有Unicode字符（包括增补字符），请使用getDirectionality(int)方法。
     * <p>
     * 参数
     * ch - char ，其请求方向性属性。
     * 结果
     * char值的方向性属性。
     */
    @Test
    public void getDirectionality() {
        System.out.println(Character.getDirectionality('?')); //13
        //支持使用代码点
    }


    /**
     * 确定是否根据Unicode规范镜像该字符。
     * 当以从右到左的文本显示时，镜像字符应使其字形水平镜像。 例如， '\u0028' LEFT PARENTHESIS在语义上被定义为左括号 。
     * 这将显示为从右到左的文本中从左到右但作为“）”的文本中的“（”。
     * 注意：此方法无法处理supplementary characters 。 要支持所有Unicode字符（包括增补字符），请使用isMirrored(int)方法。
     * <p>
     * 参数
     * ch - char ，请求镜像属性
     * 结果
     * true如果char是镜像的，则 false如果 char未镜像或未定义。
     */
    @Test
    public void isMirrored() {
        System.out.println(Character.isMirrored('\u0028'));
        //支持代码点
    }


    /**
     * 以数字方式比较两个 Character对象。
     * Specified by:
     * compareTo在界面 Comparable<Character>
     * 参数
     * anotherCharacter - 要比较的 Character 。
     * 结果
     * 值0如果参数Character等于这个Character ; 的值小于0 ，如果这Character在数值上比少Character参数;
     * 如果此Character在数值上大于Character参数（无符号比较），则值大于0 。 请注意，这是严格的数字比较; 它不依赖于语言环境。
     */
    @Test
    public void compareTo() {

    }


    /**
     * 以数字方式比较两个char值。 返回的值与返回的值相同：
     * Character.valueOf(x).compareTo(Character.valueOf(y))
     * 参数
     * x - 第一个 char来比较
     * y - 第二个 char进行比较
     * 结果
     * 值0如果x == y ; 小于0的值，如果x < y ; 如果为0则值大于x > y
     */
    @Test
    public void compare() {

    }


    /**
     * 返回通过反转指定的 char值中的字节顺序获得的值。
     * 参数
     * ch - 其中 char反转字节顺序。
     * 结果
     * 通过反转（或等效地，交换）指定的 char值中的字节获得的值。
     */
    @Test
    public void reverseBytes() {
        System.out.println(Character.reverseBytes('?')); //㼀
    }


    /**
     * 返回指定字符codePoint的Unicode名称，如果代码点为unassigned ，则返回null。
     * 注意：如果未通过UnicodeData文件（由Unicode Consortium维护的Unicode字符数据库的一部分）为指定的字符分配名称，则返回的名称与表达式的结果相同。
     * <p>
     * Character.UnicodeBlock.of(codePoint).toString().replace('_', ' ') + " " + Integer.toHexString(codePoint)
     * .toUpperCase(Locale.ROOT);
     * 参数
     * codePoint - 字符（Unicode代码点）
     * 结果
     * 指定字符的Unicode名称，如果未分配代码点，则返回null。
     */
    @Test
    public void getName() {
        System.out.println(Character.getName(300));
    }


    /**
     * 返回给定Unicode字符名称指定的Unicode字符的代码点值。
     * 注意：如果UnicodeData文件（由Unicode Consortium维护的Unicode字符数据库的一部分）未为字符分配名称，则其名称将定义为表达式的结果
     * <p>
     * Character.UnicodeBlock.of(codePoint).toString().replace('_', ' ') + " " + Integer.toHexString(codePoint)
     * .toUpperCase(Locale.ROOT);
     * name匹配不区分大小写，删除了任何前导和尾随空格字符。
     * <p>
     * 参数
     * name - Unicode字符名称
     * 结果
     * 由其名称指定的字符的代码点值。
     */
    @Test
    public void codePointOf() {
        System.out.println(Character.codePointOf("\u0000"));
    }


}
