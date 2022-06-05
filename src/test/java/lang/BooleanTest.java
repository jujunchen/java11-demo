package lang;

import org.junit.Test;

/**
 * @author jujun chen
 * @date 2020/03/22
 */
public class BooleanTest {


    /**
     * 将字符串参数解析为布尔值。
     * 返回的boolean表示值true如果字符串参数不是null并且等于（忽略大小写）字符串"true" 。
     * 否则，返回false值，包括null参数。
     * <p>
     * 示例： Boolean.parseBoolean("True")返回true 。
     * 示例： Boolean.parseBoolean("yes")返回false 。
     * <p>
     * 参数
     * s - 包含要解析的布尔表示的 String
     * 结果
     * 字符串参数表示的布尔值
     */
    @Test
    public void parseBoolean() {
        System.out.println(Boolean.parseBoolean("TRUE"));
        System.out.println(Boolean.parseBoolean("yes"));
    }

    /**
     * 输出：
     * true
     * false
     */


    /**
     * 返回表示指定的boolean值的Boolean实例。
     * 如果指定的boolean值为true ，则此方法返回Boolean.TRUE ; 如果是false ，则此方法返回Boolean.FALSE 。
     * 如果不需要新的Boolean实例，则通常应优先使用此方法，而不是构造函数Boolean(boolean) ，因为此方法可能会产生明显更好的空间和时间性能
     */
    @Test
    public void valueOf() {
        Boolean B = Boolean.valueOf("true");
        System.out.println(B);
    }

    /**
     * 输出：
     * true
     */

    /**
     * 以 Boolean元的形式返回此 Boolean对象的值。
     * 结果
     * boolean对象的原始值
     */
    @Test
    public void booleanValue() {
        Boolean B = Boolean.valueOf("TRUE");
        System.out.println(B.booleanValue());
    }
    /**
     * 输出：
     * true
     */

    /**
     * 返回true当且仅当存在由参数命名的系统属性，等于，忽略大小写，字符串"true" 。
     * <p>
     * 系统属性可通过getProperty访问，该方法由System类定义。
     * <p>
     * 如果没有具有指定名称的属性，或者指定的名称为空或null，则返回false 。
     * <p>
     * 参数
     * name - 系统属性名称。
     * 结果
     * 系统属性的值为 boolean 。
     */
    @Test
    public void getBoolean() {
        System.out.println(Boolean.getBoolean("java"));
        ;
    }

    /**
     * 输出：
     * false
     */

    /**
     * 返回将逻辑AND运算符应用于指定的 boolean操作数的结果。
     * 参数
     * a - 第一个操作数
     * b - 第二个操作数
     * 结果
     * 逻辑AND为 a和 b
     */
    @Test
    public void logicalAnd() {
        System.out.println(Boolean.logicalAnd(true, false));
        System.out.println(Boolean.logicalAnd(true, true));
    }
    /**
     * 输出：
     * false
     * true
     */


    /**
     * 返回将逻辑OR运算符应用于指定的 boolean操作数的结果
     */
    @Test
    public void logicalOr() {
        System.out.println(Boolean.logicalOr(true, false));
    }
    /**
     * 输出：
     * true
     */


    /**
     * 返回将逻辑XOR运算符应用于指定的 boolean操作数的结果
     */
    @Test
    public void logicalXor() {
        System.out.println(Boolean.logicalXor(true, false));
        System.out.println(Boolean.logicalXor(false, false));
    }
    /**
     * 输出：
     * true
     * false
     */
}
