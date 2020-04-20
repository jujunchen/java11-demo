package lang;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * @author jujun chen
 * @date 2020/04/20
 */
public class SystemTest {


    /**
     * 从键盘等设备获取输入流
     * @throws IOException
     */
    @Test
    public void in() throws IOException {
    }

    /**
     * 准备输出流
     */
    @Test
    public void out() {

    }

    /**
     * 表示错误的输出流
     */
    @Test
    public void err() {

    }

    /**
     * 重新分配标准输入流
     */
    @Test
    public void setIn() throws IOException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("File.txt");
        System.setIn(inputStream);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(bufferedReader.readLine());
    }

    /**
     * 重新分配标准输出流
     */
    @Test
    public void setOut() {

    }

    /**
     * 重新分配标准错误输出流
     */
    @Test
    public void setErr() {

    }

    /**
     * 获取控制台对象，IDE之外使用
     */
    @Test
    public void console() {
        Console console = System.console();
        System.out.println(console.readLine());
    }


    /**
     * 将指定的数组从指定位置开始复制到目标数组的指定位置
     * 参数
     * src - 源数组。
     * srcPos - 源数组中的起始位置。
     * dest - 目标数组。
     * destPos - 目标数据中的起始位置。
     * length - 要复制的数组元素的数量。
     */
    @Test
    public void arraycopy() {
        char[] chars1 = new char[]{'a','b','c'};
        char[] chars2 = new char[4];
        System.arraycopy(chars1,0,chars2,0,3);
        System.out.println(Arrays.toString(chars2));
    }


    /**
     * 返回默认的hashCode
     */
    @Test
    public void identityHashCode() {
        Person person = new Person();
        System.out.println(person.hashCode());
        System.out.println(System.identityHashCode(person));
        //可以去掉Person重写的hashCode 比较
        System.out.println(Objects.hashCode(person));
    }

    /**
     * 获取当前环境的系统属性
     */
    @Test
    public void getProperties() {
        Properties properties = System.getProperties();
        System.out.println(properties.getProperty("os.name"));
    }

    /**
     * 返回基于系统的行分隔符字符串
     */
    @Test
    public void lineSeparator() {
        System.out.println(System.lineSeparator());
    }

    /**
     * 获取指定环境变量的值，环境变量依赖于系统
     */
    @Test
    public void getenv() {
        System.out.println(System.getenv("PWD"));

        //返回获取环境变量
        Map<String,String> envs = System.getenv();
    }

    /**
     * 终止当前运行的虚拟机，非零代表异常退出
     * 实际调用 Runtime.getRuntime().exit()
     */
    @Test
    public void exit() {

    }

    /**
     * 运行垃圾收集器
     * 实际调用 Runtime.getRuntime.gc()
     */
    @Test
    public void gc() {
        
    }

    /**
     * 运行待完成的任何对象的finalize方法
     * Runtime.getRuntime().load(name)
     */
    @Test
    public void runFinalization() {
        
    }

    @Test
    public void load() {
        //Runtime.getRuntime().load(name)
        //加载filename参数指定的本机库。 filename参数必须是绝对路径名
    }


    /**
     * 加载libname参数指定的本机库。
     * libname参数不得包含任何特定于平台的前缀，文件扩展名或路径。
     * Runtime.getRuntime().load(name)
     */
    @Test
    public void loadLibrary() {
    }

    /**
     * 将库名称映射到表示本机库的特定于平台的字符串
     */
    @Test
    public void mapLibraryName() {
        System.out.println(System.mapLibraryName("java.version"));
    }
    
}
