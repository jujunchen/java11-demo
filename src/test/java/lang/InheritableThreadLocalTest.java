package lang;

import org.junit.Test;

/**
 * @author jujun chen
 * @date 2020/03/26
 */
public class InheritableThreadLocalTest {

    @Test
    public void test1() throws InterruptedException {
        InheritableThreadLocal<String> mainThread = new InheritableThreadLocal();
        mainThread.set("main thread");
        Thread sonThread = new Thread(() -> {
            //能够读取到主线程的数据
            System.out.println(mainThread.get());
        });

        sonThread.start();
        sonThread.join();
        mainThread.remove();
    }
}
