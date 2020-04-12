package lang;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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

    /**
     * 注册新的虚拟机关闭钩子，当虚拟机退出的时候，将调用关闭钩子
     */
    @Test
    public void addShutdownHook() throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        runtime.addShutdownHook(new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("execute shutdown hook");
        }));

        //0的时候为立即停止，不执行钩子
//        runtime.exit(0);
        runtime.exit(-1);

        //删除钩子
        //runtime.removeShutdownHook();
    }


    /**
     * 强制终止当前运行的虚拟机
     */
    @Test
    public void halt() {
        Runtime runtime = Runtime.getRuntime();

        runtime.addShutdownHook(new Thread(() -> {
            System.out.println("execute shutdown hook");
        }));
        //不执行钩子
        runtime.halt(-1);
    }


    @Test
    public void exec() throws IOException {
        Runtime runtime = Runtime.getRuntime();

        //在单独的进程中执行指定的字符串命令
        //Process process = runtime.exec("ls");

        //指定命名，和命令参数
        Process process = runtime.exec(new String[]{"ls","-l"});

        //在指定环境配置的单独进程中执行指定的字符串命令
        //command - 指定的系统命令。
        //envp - 字符串数组，其每个元素的格式为 name = value的环境变量设置，如果子进程应继承当前进程的环境则为null 。
        //Process process = runtime.exec("ls",new String[]{});

        //同样可以配置环境
        //Process process = runtime.exec(new String[]{"ls","-l"},new String[]{});


        //在具有指定环境和工作目录的单独进程中执行指定的字符串命令
        //Process process = runtime.exec("ls",new String[]{},new File("/opt"));

        //配置目录
        //Process process = runtime.exec(new String[]{"ls","-l"},new String[]{},new File("/opt"));

        InputStream inputStream = process.getInputStream();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }


    /**
     * 返回虚拟机可用处理器数
     */
    @Test
    public void availableProcessors() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }


    /**
     * 返回虚拟机的可用内存量
     */
    @Test
    public void freeMemory() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            Person person = new Person();
        }

        System.out.println(Runtime.getRuntime().freeMemory());

        //回收下内存
        Runtime.getRuntime().gc();


        System.out.println(Runtime.getRuntime().freeMemory());
    }

    /**
     * 返回Java虚拟机中的内存总量
     */
    @Test
    public void totalMemory() {
        System.out.println(Runtime.getRuntime().totalMemory());
    }

    /**
     * 返回Java虚拟机将尝试使用的最大内存量
     */
    @Test
    public void maxMemory() {
        System.out.println(Runtime.getRuntime().maxMemory());
    }
    
    @Test
    public void runFinalization() throws InterruptedException {

        class Person {
            @Override
            protected void finalize() throws Throwable {
                System.out.println("execute finalize");
            }
        }

        for (int i = 0; i < 1000; i++) {
            Person person = new Person();
        }

        Thread.sleep(1000);

        //没有执行finalize方法？
        Runtime.getRuntime().runFinalization();
        //会执行finalize方法
//        System.gc();
    }
    
    
    
    @Test
    public void load() {
        //加载filename参数指定的本机库。 filename参数必须是绝对路径名    
    }


    /**
     * 加载libname参数指定的本机库。
     * libname参数不得包含任何特定于平台的前缀，文件扩展名或路径。
     */
    @Test
    public void loadLibrary() {
        Runtime.getRuntime().loadLibrary("libName");
    }

}
