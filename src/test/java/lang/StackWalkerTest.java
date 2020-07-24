package lang;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author jujun chen
 * @date 2020/04/13
 */
public class StackWalkerTest {

    /**
     * 返回StackWalker实例
     */
    @Test
    public void getInstance() {
        StackWalker stackWalker = StackWalker.getInstance();

        //指定选项
        StackWalker stackWalker2 = StackWalker.getInstance(StackWalker.Option.SHOW_HIDDEN_FRAMES);

        //指定多个选项
        Set set = new HashSet();
        set.add(StackWalker.Option.SHOW_HIDDEN_FRAMES);
        set.add(StackWalker.Option.SHOW_REFLECT_FRAMES);
        StackWalker stackWalker3 = StackWalker.getInstance(set);
    }


    /**
     * 将函数应用于当前线程的StackFrame流
     */
    @Test
    public void walk() {
        List<StackWalker.StackFrame> frames = StackWalker.getInstance().walk(s ->
                s.dropWhile(f -> f.getClassName().startsWith("com.foo."))
                        .limit(10)
                        .collect(Collectors.toList()));
        System.out.println(frames);
    }


    /**
     * 对当前线程的StackFrame流的每个元素执行给定操作，从堆栈的顶部帧遍历，这是调用此forEach方法的方法。
     * 这种方法相当于调用
     * <p>
     * walk(s -> { s.forEach(action); return null; });
     * 参数
     * action - 要对当前线程的堆栈的每个 StackFrame执行的操作
     */
    @Test
    public void forEach() {
        StackWalker.getInstance().forEach(item -> {
            System.out.println(item);
        });
    }


    /**
     * 获取调用者调用getCallerClass的方法的类对象
     */
    @Test
    public void getCallerClass() {
        Class cls = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE).getCallerClass();
        System.out.println(cls.getName());
    }


}
