package util;

import org.junit.Test;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author jujun chen
 * @date 2020/07/10
 */
public class ConcurrentLinkedQueueTest {

    @Test
    public void test1() {
        ConcurrentLinkedQueue<Integer> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();

        concurrentLinkedQueue.add(1);
        concurrentLinkedQueue.add(2);
        concurrentLinkedQueue.add(3);
    }
}
