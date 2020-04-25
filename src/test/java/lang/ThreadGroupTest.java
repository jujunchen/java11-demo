package lang;

import org.junit.Test;

/**
 * @author jujun chen
 * @date 2020/04/25
 */
public class ThreadGroupTest {

    ThreadGroup threadGroup = new ThreadGroup("ThreadGroupName");

    /**
     * 返回此线程组中的最大优先级
     */
    @Test
    public void getMaxPriority() throws InterruptedException {
        System.out.println(threadGroup.getMaxPriority());
        Thread thread = new Thread(threadGroup,() -> System.out.println("This is a thead"));
        //只能1-10
//        thread.setPriority(20);
        System.out.println(threadGroup.getMaxPriority());

        System.out.println(threadGroup.getParent());

        //设置线程组为守护线程组，守护线程组在其最后一个线程停止或者最后一个线程组被销毁后自动销毁
        threadGroup.setDaemon(true);

        System.out.println(threadGroup.isDaemon());

        //销毁此线程组及其所有子组
        threadGroup.destroy();

        System.out.println(threadGroup.isDestroyed());
    }


    /**
     * 返回此线程组及其子组中活动线程数的估计值。 递归迭代此线程组中的所有子组。
     * 返回的值只是一个估计值，因为当此方法遍历内部数据结构时，线程数可能会动态更改，并且可能会受到某些系统线程的影响。
     * 此方法主要用于调试和监视目的。
     */
    @Test
    public void activeCount() {

    }


    /**
     * 将线程组及其子组中的每个活动线程复制到指定数组中
     */
    @Test
    public void enumerate() {

        /*
        将此线程组中的每个活动线程复制到指定的数组中。 如果recurse是true ，则此方法以递归方式枚举此线程组的所有子组，并且还包括对这些子组中每个活动线程的引用。 如果数组太短而无法容纳所有线程，则会以静默方式忽略额外的线程。
        应用程序可能会使用activeCount方法来估计数组应该有多大，但是如果数组太短而无法容纳所有线程，则会以静默方式忽略额外的线程。 如果获取此线程组中的每个活动线程至关重要，则调用者应验证返回的int值是否严格小于list的长度。

        由于此方法存在固有的竞争条件，因此建议仅将该方法用于调试和监视目的。

        参数
        list - 要放置线程列表的数组
        recurse - 如果为 true ，则递归枚举此线程组的所有子组
         */
        //enumerate​(Thread[] list, boolean recurse)
    }


    @Test
    public void activeGroupCount() {
        Thread thread = new Thread(threadGroup,() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        System.out.println(threadGroup.activeGroupCount());
    }

    /**
     * 将有关此线程组的信息打印到标准输出
     */
    @Test
    public void list() {
        threadGroup.list();
    }

    @Test
    public void toString1() {
        System.out.println(threadGroup.toString());
    }
}
