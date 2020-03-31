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

    /**
     * 返回包含此模块的模块层。
     * 如果此模块不在模块层中，返回null。
     *
     * 模块层只包含命名模块，如果在未命名模块上调用，返回null
     */
    @Test
    public void getLayer() {
        Module module = String.class.getModule();
        ModuleLayer moduleLayer = module.getLayer();
        System.out.println(moduleLayer.toString());
    }

    /**
     * 表示此模块是否读取给定模块。
     * 如果调用此方法读取自身，则此方法返回true 。
     * 如果在未命名的模块上调用它也会返回true （因为未命名的模块读取所有模块）
     */
    @Test
    public void canRead() {
        Module module = String.class.getModule();
        Module module1 = List.class.getModule();

        System.out.println(module.canRead(module1));
    }

    /**
     * 如果调用者模块与当前模块相同，则更新当前模块对应的值为指定模块。
     * 如果指定模块与当前模块相同，则不做任何操作
     *
     */
    @Test
    public void addReads() {
        Module module = String.class.getModule();
        Module module1 = List.class.getModule();
        module.addReads(module1);
    }
}
