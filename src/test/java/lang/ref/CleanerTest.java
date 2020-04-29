package lang.ref;

import org.junit.Test;

import java.lang.ref.Cleaner;

/**
 * @author jujun chen
 * @date 2020/04/29
 */
public class CleanerTest {

    @Test
    public void create() {
        Cleaner cleaner = Cleaner.create();
        cleaner.register(new Object(), () -> System.out.println("Hello World"));
    }
}
