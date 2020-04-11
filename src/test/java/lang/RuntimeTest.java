package lang;

import org.junit.Test;

/**
 * @author jujun chen
 * @date 2020/04/11
 */
public class RuntimeTest {

    /**
     * 返回当前程序关联的运行时对象
     */
    @Test
    public void getRuntime() {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.getClass());
    }

    /**
     * 终止当前运行的虚拟机
     * 同 System.exit
     * 非零表示立即停止
     */
    @Test
    public void exit() throws InterruptedException {
        new Thread(() -> {
            Runtime.getRuntime().exit(-1);
        }).start();

        Thread.sleep(3000);
    }
}
