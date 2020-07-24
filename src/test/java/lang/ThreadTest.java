package lang;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;

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
        Thread.sleep(1000, 1000);
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
     * <p>
     * 如果该线程阻塞的调用wait() ， wait(long) ，或wait(long, int)的方法Object类，或的join() ， join(long) ， join(long, int) ， sleep
     * (long) ，或sleep(long, int) ，这个类的方法，那么它的中断状态将被清除，并且将收到InterruptedException 。
     * <p>
     * 如果在InterruptibleChannel上的I / O操作中阻止该线程，则通道将关闭，线程的中断状态将被设置，线程将收到ClosedByInterruptException 。
     * <p>
     * 如果该线程在Selector中被阻塞，则线程的中断状态将被设置，它将立即从Selector返回，可能具有非零值，就像调用Selector的wakeup方法一样。
     * <p>
     * 如果以前的条件都不成立，则将设置该线程的中断状态。
     * <p>
     * 中断不活动的线程不会产生任何影响。
     */
    @Test
    public void interrupt() {

    }

    /**
     * 判断当前线程是否已被中断。该操作将清除线程的中断状态
     * true 线程被中断，false 线程未被中断
     */
    @Test
    public void interrupted() throws InterruptedException {
        //中断当前线程
        Thread.currentThread().interrupt();
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
    }

    /**
     * 判断指定的线程是否已被中断，该操作不会清除线程的中断状态
     * true 线程被中断， false 线程未被中断
     */
    @Test
    public void isInterrupted() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                FileWriter fileWriter = new FileWriter("test.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for (int i = 0; i < 1000000000; i++) {
//                    bufferedWriter.write(String.valueOf(i));
//                    bufferedWriter.newLine();
                    System.out.println(i);
                    Thread.sleep(10);
                }

                System.out.println("aaaa");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("线程内部判断是否中断：" + Thread.currentThread().isInterrupted());
        });
        System.out.println("thread start...");
        thread.start();
        System.out.println("线程是否存活：" + thread.isAlive());
        /*
        如果该线程阻塞的调用wait() ， wait(long) ，或wait(long, int)的方法Object类，

        或的join() ， join(long) ， join(long, int) ， sleep(long) ，或sleep(long, int) ，

        这个类的方法，那么它的中断状态将被清除，即调用isInterrupted会返回false,并且将收到InterruptedException 。

        如果在InterruptibleChannel上的I / O操作中阻止该线程，则通道将关闭，线程的中断状态将被设置，线程将收到ClosedByInterruptException 。

        如果该线程在Selector中被阻塞，则线程的中断状态将被设置，它将立即从选择操作返回，可能具有非零值，就像调用选择器的wakeup方法一样。

        如果以前的条件都不成立，则将设置该线程的中断状态。
         */
        thread.interrupt();
        System.out.println("thread interrupt...");

        System.out.println("线程是否中断：" + thread.isInterrupted());
        System.out.println("再次检查线程是否中断：" + thread.isInterrupted());
        //判断线程是否存活,即使线程被中断了，只要是没有执行完任务，线程算存活
        System.out.println("线程是否存活：" + thread.isAlive());

        //等待一会
        Thread.sleep(3000);
    }

    /**
     * 更改此线程的优先级,线程优先级 1- 10，默认优先级5
     */
    @Test
    public void setPriority() throws InterruptedException {
        Thread thread0 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "(" + Thread.currentThread().getPriority() + ")");
            }
        });
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "(" + Thread.currentThread().getPriority() + ")");
            }
        });
        thread0.setPriority(1);
        thread0.start();
        thread1.start();

        Thread.sleep(3000);
    }


    /**
     * 返回当前线程thread group及其子组中活动线程数的估计值。 递归迭代当前线程的线程组中的所有子组。
     * 返回的值只是一个估计值，因为当此方法遍历内部数据结构时，线程数可能会动态更改，并且可能会受到某些系统线程的影响。
     * 此方法主要用于调试和监视目的。
     * <p>
     * 结果
     * 估计当前线程的线程组和当前线程的线程组作为祖先的任何其他线程组中的活动线程数
     */
    @Test
    public void activeCount() {

    }


    /**
     * 将当前线程的线程组及其子组中的每个活动线程复制到指定的数组中。
     * 此方法只调用当前线程的线程组的ThreadGroup.enumerate(Thread[])方法。
     * 应用程序可能会使用activeCount方法来估计数组应该有多大，但是如果数组太短而无法容纳所有线程，则会以静默方式忽略额外的线程。
     * 如果获取当前线程的线程组及其子组中的每个活动线程至关重要，则调用者应验证返回的int值是否严格小于tarray的长度。
     * <p>
     * 由于此方法存在固有的竞争条件，因此建议仅将该方法用于调试和监视目的。
     * <p>
     * 参数
     * tarray - 要放置线程列表的数组
     * 结果
     * 放入数组的线程数
     */
    @Test
    public void enumerate() {
        ThreadGroup threadGroup = new ThreadGroup("ThreadGroup1");
        Thread thread = new Thread(threadGroup, () -> System.out.println("thread"));
        Thread[] threadAry = new Thread[1];
        //当前线程为main线程
        Thread.enumerate(threadAry);
        for (Thread item : threadAry) {
            System.out.println(item.getName());
            ;
        }
    }


    /**
     * 一直等待指定时间，直到线程执行结束，0表示一直等待
     *
     * @throws InterruptedException
     */
    @Test
    public void join() throws InterruptedException {
        Thread thread0 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "(" + Thread.currentThread().getPriority() + ")");
            }
        });
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "(" + Thread.currentThread().getPriority() + ")");
            }
        });
        thread0.setPriority(1);
        thread0.start();
        //等待thread0  1秒
        thread0.join(1000);
        thread1.start();

//如果放在线程开始的后面，是达不到线程顺序执行效果的
//        thread0.join();
//        thread1.join();

        Thread.sleep(3000);
    }


    /**
     * 设置守护线程
     * <p>
     * 如果当前的线程只剩守护线程，Java虚拟机就会退出
     * <p>
     * 该方法必须在start方法前调用
     */
    @Test
    public void setDaemon() throws InterruptedException {
        Thread thread = new Thread(() -> System.out.println("thread"));
        thread.setDaemon(true);
        thread.start();

        Thread.sleep(3000);

        //测试线程是否为守护线程
        System.out.println(thread.isDaemon());
    }


    /**
     * 返回此线程的上下文ClassLoader
     */
    @Test
    public void getContextClassLoader() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader.getName());

        //设置线程的ClassLoader
//        Thread.currentThread().setContextClassLoader();
    }


    /**
     * 当且仅当当前线程在指定对象上保存监视器锁时，返回true 。
     * 此方法旨在允许程序断言当前线程已经拥有指定的锁：
     * <p>
     * assert Thread.holdsLock(obj);
     */
    @Test
    public void holdsLock() {

    }


    /**
     * 获取线程的标识，线程ID是创建此线程事生成的正数long,在生命周期内保持不变，唯一，线程终止后，可以重用该线程ID
     */
    @Test
    public void getId() {
        System.out.println(Thread.currentThread().getId());
        Thread thread = new Thread();
        System.out.println(thread.getId());
    }


    /**
     * 返回此线程的状态。 此方法设计用于监视系统状态，而不是用于同步控制
     */
    @Test
    public void getState() {
        Thread.State state = Thread.currentThread().getState();
        System.out.println(state);
    }

}
