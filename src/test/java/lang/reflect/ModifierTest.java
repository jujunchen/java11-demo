package lang.reflect;

import org.junit.Test;

import java.lang.reflect.Modifier;

/**
 * @author jujun chen
 * @date 2020/05/11
 */
public class ModifierTest {

    @Test
    public void isPublic() {
    }

    /**
     * strictfp, 即 strict float point (精确浮点)。
     * strictfp 关键字可应用于类、接口或方法。
     * 使用 strictfp 关键字声明一个方法时，该方法中所有的float和double表达式都严格遵守FP-strict的限制,
     * 符合IEEE-754规范。当对一个类或接口使用 strictfp 关键字时，该类中的所有代码，包括嵌套类型中的初始设定值和代码，都将严格地进行计算。
     * 严格约束意味着所有表达式的结果都必须是 IEEE-754
     * 算法对操作数预期的结果，以单精度和双精度格式表示。
     * <p>
     * 但java 11下，是否使用strictfp结果一样
     */
    @Test
    public void isStrict() {
        StrictTest.test();

        StrictTest2.test();

        //没用？
        int mod = StrictTest.class.getModifiers();
        System.out.println(Modifier.isStrict(mod));
    }
}

strictfp class StrictTest {

    public static void test() {
        float f = 0.0333000000222f;
        System.out.println(f);
    }
}

class StrictTest2 {

    public static void test() {
        float f = 0.0333000000222f;
        System.out.println(f);
    }
}
