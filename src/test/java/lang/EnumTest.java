package lang;

import org.junit.Test;

/**
 * @author jujun chen
 * @date 2020/03/24
 */
public class EnumTest {

    /**
     * 返回此枚举常量的名称
     */
    @Test
    public void name() {
        System.out.println(Status.CLOSE.name());
        System.out.println(Status.CLOSE);
    }


    /**
     * 返回此枚举常量的序数
     */
    @Test
    public void ordinal() {
        System.out.println(Status.CLOSE.ordinal());
        System.out.println(Status.OPEN.ordinal());
    }

    /**
     * 如果指定的对象等于此枚举常量，返回true
     */
    @Test
    public void equals() {
        System.out.println(Status.CLOSE.equals(Status.OPEN));
    }


    /**
     * 返回此枚举常量的哈希码
     */
    @Test
    public void hashcode() {
        System.out.println(Status.CLOSE.hashCode());
    }


    /**
     * 通过枚举常量的序号来比较
     * <p>
     * 返回负整数，零或正整数，对应对象小于，等于或大于指定对象
     */
    @Test
    public void compareTo() {
        System.out.println(Status.CLOSE.compareTo(Status.OPEN));
    }


    /**
     * 返回与此枚举常量的枚举类型对应的Class对象。
     * <p>
     * 当且仅当e1.getDeclaringClass（）== e2.getDeclaringClass（）时，两个枚举常量e1和e2具有相同的枚举类型。
     * <p>
     * （此方法返回的值可能与Object.getClass()方法返回的值不同，对于具有常量特定类主体的枚举常量。）
     */
    @Test
    public void getDeclaringClass() {
        Class cls = Status.CLOSE.getDeclaringClass();
        Class cls2 = Status.OPEN.getClass();
    }


    /**
     * 返回具有指定名称的枚举类型的枚举常量
     */
    @Test
    public void valueOf() {
        assert Status.valueOf(Status.class, "CLOSE").equals(Status.CLOSE);
    }

}
