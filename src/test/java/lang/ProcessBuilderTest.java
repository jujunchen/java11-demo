package lang;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jujun chen
 * @date 2020/04/03
 */
public class ProcessBuilderTest {

    /**
     * 返回此进程生成器的操作系统程序和参数。 返回的列表不是一个新副本
     */
    @Test
    public void command() {
        List<String> commands = new ArrayList();
        commands.add("notepad.exe");

        ProcessBuilder processBuilder = new ProcessBuilder(commands);
        System.out.println(processBuilder.command());
    }

    /**
     * 返回操作系统环境变量
     */
    @Test
    public void environment() {
        System.out.println(new ProcessBuilder().environment());
    }


    /**
     * 返回此流程构建器的工作目录。 随后由此对象启动的子进程的start()方法将使用此作为其工作目录。 返回的值可能是null - 这意味着使用当前Java进程的工作目录，通常是系统属性user.dir指定的目录，作为子进程的工作目录。
     * @throws IOException
     */
    @Test
    public void directory() throws IOException {
        File file = new ProcessBuilder().directory();
    }
}
