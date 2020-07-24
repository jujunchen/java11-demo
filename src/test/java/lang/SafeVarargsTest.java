package lang;

/**
 * @author jujun chen
 * @date 2020/04/11
 */
public class SafeVarargsTest<T> {

    private T[] args;

    @SafeVarargs
    public SafeVarargsTest(T... args) {
    }

    @SuppressWarnings("unchecked")
//    @SafeVarargs //不能使用，方法未声明为static 或final
    public void loopArgs(T... args) {
        for (T arg : args) {
            System.out.println(arg);
        }
    }


    @SafeVarargs
    public final void finalArgs(T... args) {

    }

    @SafeVarargs
    public static <T> void staticArgs(T... args) {

    }

    @SafeVarargs
    private void privateArgs(T... args) {

    }


}
