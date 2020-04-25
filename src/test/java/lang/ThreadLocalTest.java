package lang;

import org.junit.Test;

/**
 * @author jujun chen
 * @date 2020/04/25
 */
public class ThreadLocalTest {

    /*
    返回此线程局部变量的当前线程的“初始值”。
    该方法将被调用的第一次一个线程访问与可变get()方法，除非线程先前调用的set(T)方法，在这种情况下initialValue方法将不被调用的线程。
    通常，每个线程最多调用一次此方法，但如果后续调用remove()后跟get() ，则可以再次调用此方法。
    这个实现只返回null ;
    如果程序员希望线程局部变量具有除null之外的初始值， ThreadLocal必须对ThreadLocal进行子类化，并且重写此方法。
    通常，将使用匿名内部类。
     */
    ThreadLocal threadLocal = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return "init";
        }
    };

    /*
    创建一个线程局部变量。 通过调用get上的Supplier方法确定变量的初始值
     */
    ThreadLocal threadLocal2 = ThreadLocal.withInitial(() -> "init");

    @Test
    public void get() {
        System.out.println(threadLocal.get());
    }


    @Test
    public void set() {
        System.out.println(threadLocal2.get());
        threadLocal2.set("run");
        System.out.println(threadLocal2.get());
        //删除后，再次调用get，会再次执行initialValue
        threadLocal2.remove();
        System.out.println(threadLocal2.get());
    }
}
