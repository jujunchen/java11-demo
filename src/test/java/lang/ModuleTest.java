package lang;

import org.junit.Test;

import java.lang.module.ModuleDescriptor;
import java.util.List;

/**
 * @author jujun chen
 * @date 2020/03/29
 */
public class ModuleTest {

    /**
     * 如果模块是命名模块，返回true
     */
    @Test
    public void isNamed() {
        Module module = String.class.getModule();
        assert module.isNamed();
    }

    /**
     * 返回模块名称
     */
    @Test
    public void getName() {
        Module module = String.class.getModule();
        System.out.println(module.getName());
    }

    /**
     * 返回加载模块ClassLoader
     */
    @Test
    public void getClassLoader() {
        Module module = List.class.getModule();
        ClassLoader classLoader = module.getClassLoader();
    }

    /**
     * 返回此模块的描述符
     */
    @Test
    public void getDescriptor() {
        Module module = List.class.getModule();
        ModuleDescriptor moduleDescriptor = module.getDescriptor();
    }
}
