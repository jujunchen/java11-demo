package lang;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    public void command() throws IOException {
        List<String> commands = new ArrayList();
        commands.add("java");
        commands.add("-vesion");

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
     * 返回此流程构建器的工作目录。
     *
     * 随后由此对象启动的子进程的start()方法将使用此作为其工作目录。
     *
     * 返回的值可能是null - 这意味着使用当前Java进程的工作目录，通常是系统属性user.dir指定的目录，作为子进程的工作目录。
     */
    @Test
    public void directory() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java","-version");
        processBuilder.start();
        //设置工作目录前是null
        File file = processBuilder.directory();
        System.out.println(file);
        String str = System.getProperty("user.dir");
        System.out.println(str);
        /*
        设置此流程构建器的工作目录
         */
        ProcessBuilder file1 = new ProcessBuilder().directory(new File(str));
        System.out.println(file1.directory());
    }

    /**
     * 设置此流程构建器的标准输入源。
     *
     * 随后由此对象的start()方法启动的子进程从此源获取其标准输入。
     *
     * 如果源是Redirect.PIPE （初始值），则可以使用Process.getOutputStream()返回的输出流写入子进程的标准输入。 如果源设置为任何其他值，则Process.getOutputStream()
     *
     * 将返回null output stream 。
     *
     * 参数
     *      source - 新的标准输入源
     *
     * https://www.cnblogs.com/mistor/p/6129682.html
     */
    @Test
    public void redirectInput() throws Exception {
        ProcessBuilder processBuilder = new ProcessBuilder("zsh");
        //将错误输出合并到标准输出流中，以便process.getInputStream()直接读取
        processBuilder.redirectErrorStream(true);
        //重定向输入
        File input = new File(getClass().getResource("/redirectInput.sh").toURI());
        processBuilder.redirectInput(input);

        //重定向输出
        File outFile = new File(getClass().getResource("/redirectOutput.txt").toURI());
        processBuilder.redirectOutput(outFile);

        //启动构建器，执行命令
        Process process = processBuilder.start();

        InputStream inputStream = process.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        //一直等待直到process进程终止，返回0
        final int status = process.waitFor();
    }


    /**
     * 为每个ProcessBuilder启动一个Process，创建一个由标准输出和标准输入流链接的流程管道。
     * 前面的输出流是后一个的输入流,不能访问中间进程的输入和输出流，除了第一个和最后一个
     */
    @Test
    public void startPipeline() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("pwd");
        ProcessBuilder pb1 = new ProcessBuilder("xargs", "echo");
        List<ProcessBuilder> builderList = new ArrayList<>();
        builderList.add(pb);
        builderList.add(pb1);

        List<Process> processList = ProcessBuilder.startPipeline(builderList);
        Process process = processList.get(processList.size() - 1);
        InputStream inputStream = process.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

    }

}
