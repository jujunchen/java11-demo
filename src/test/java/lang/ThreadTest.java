package lang;

import org.junit.Test;

/**
 * @author jujun chen
 * @date 2020/04/21
 */
public class ThreadTest {

    @Test
    public void Thread() {
        ThreadGroup threadGroup = new ThreadGroup("ThreadGroup1");
        Thread thread = new Thread(threadGroup, new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello Java");
            }
        });
        thread.start();
    }

    /**
     * 返回当前执行线程的引用
     */
    @Test
    public void currentThread() {

    }

    /**
     * 让出当前线程正在使用的CPU资源
     */
    @Test
    public void yield() {

    }


    /**
     * 使当前线程执行休眠指定的毫秒数，该线程会释放CPU资源,但不会释放监听的锁资源
     */
    @Test
    public void sleep() throws InterruptedException {

        //使当前线程执行指定的毫秒数加上指定的纳秒数
        Thread.sleep(1000,1000);
    }


    //https://www.jianshu.com/p/14a50f0f78e0

    /**
     * 表示调用者暂时不能继续进行，直到其他活动发生一个或多个操作为止
     * 在自旋等待循环结构中每次迭代调用此方法，能够提高性能
     */
    @Test
    public void onSpinWait() {

    }


    /**
     * 启动线程，虚拟机开始调用线程的run方法
     */
    @Test
    public void start() {
        
    }


    /**
     * 如果此线程使用Runnable构造，则该方法将调用Runnable对象的run方法
     * 并没有启动新线程
     */
    @Test
    public void run() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Hello Java");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.run();

        System.out.println("end....");
    }

    /**
     * 中断此线程。
     * 除非当前线程正在中断（始终允许）， 否则将调用此线程的checkAccess方法，这可能会导致抛出SecurityException 。
     *
     * 如果该线程阻塞的调用wait() ， wait(long) ，或wait(long, int)的方法Object类，或的join() ， join(long) ， join(long, int) ， sleep
     * (long) ，或sleep(long, int) ，这个类的方法，那么它的中断状态将被清除，并且将收到InterruptedException 。
     *
     * 如果在InterruptibleChannel上的I / O操作中阻止该线程，则通道将关闭，线程的中断状态将被设置，线程将收到ClosedByInterruptException 。
     *
     * 如果该线程在Selector中被阻塞，则线程的中断状态将被设置，它将立即从Selector返回，可能具有非零值，就像调用Selector的wakeup方法一样。
     *
     * 如果以前的条件都不成立，则将设置该线程的中断状态。
     *
     * 中断不活动的线程不会产生任何影响。
     */
    @Test
    public void interrupt() {

    }

}
