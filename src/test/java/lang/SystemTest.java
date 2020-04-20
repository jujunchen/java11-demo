package lang;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
}
