package lang;

import org.junit.Test;

/**
 * @author jujun chen
 * @date 2020/03/23
 */
public class ClassLoaderTest {

    /**
     * 返回类加载器的名称，如果未指定返回null
     */
    @Test
    public void getName() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        System.out.println(classLoader.getName());
    }


    /**
     * 加载指定全限定名的类，相当于调用 {@link ClassLoader#loadClass(String, boolean) loadClass(name,false)}
     * <p>
     * 不会输出 静态代码块中的内容
     *
     * @throws ClassNotFoundException
     */
    @Test
    public void loadClass() throws ClassNotFoundException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        Class cls = classLoader.loadClass("lang.ChinesePeople");
    }


    /**
     * 返回父类加载器
     * <p>
     * 某些实现可能使用null来表示引导类加载器。 如果此类加载器的父级是引导类加载器，则此方法将在此类实现中返回null
     */
    @Test
    public void getParent() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        ClassLoader parentClassLoader = classLoader.getParent();
        System.out.println(parentClassLoader.getName());
        //返回null
        ClassLoader parentClassLoader2 = parentClassLoader.getParent();
//        System.out.println(parentClassLoader2.getName());
    }


    /**
     * 返回此类加载器的未命名模块
     */
    @Test
    public void getUnnamedModule() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        Module module = classLoader.getUnnamedModule();
        System.out.println(module.getName());
    }


    /**
     * 返回系统类加载器。
     * <p>
     * 这是新ClassLoader实例的默认委托父级，通常是用于启动应用程序的类装入器
     */
    @Test
    public void getSystemClassLoader() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        //输出app
        System.out.println(systemClassLoader.getName());
    }

    /**
     * 该软件包给定的名字已被这个类加载器定义，如果未找到 返回null
     */
    @Test
    public void getDefinedPackage() {
        ClassLoader classLoader = getClass().getClassLoader();
        Package pk = classLoader.getDefinedPackage("lang");
        System.out.println(pk.getName());
    }

    /**
     * 返回此类加载器定义的所有软件包。返回的数组没有重复的软件包名
     */
    @Test
    public void getDefinedPackages() {
        ClassLoader classLoader = getClass().getClassLoader();
        Package[] packages = classLoader.getDefinedPackages();
    }

    /**
     * 设置此类加载器默认的断言状态
     *
     * <a>https://blog.csdn.net/dominic_z/article/details/104639171</a>
     * <a>http://blog.sina.com.cn/s/blog_ed7fd8610102v0f4.html</a>
     */
    @Test
    public void setDefaultAssertionStatus() {

    }


    /**
     * 设置命名包的包默认断言状态。 包默认断言状态确定将来初始化的类的断言状态，这些类属于命名包或其任何“子包”。
     * 名为p的包的子包是名称以“ p. ”开头的任何包。 例如， javax.swing.text是的一个子包javax.swing ，并且两个java.util和java.lang.reflect是子包java 。
     * <p>
     * 如果多个包默认值适用于给定的类，则与特定包最相关的包默认优先于其他包。 例如，如果javax.lang和javax.lang.reflect都具有与之关联的包默认值，则后一个包默认应用于javax.lang.reflect类。
     * <p>
     * 包默认值优先于类加载器的默认断言状态，并且可以通过调用setClassAssertionStatus(String, boolean)在每个类的基础上重写 。
     * <p>
     * 参数
     * packageName - 要设置其包默认断言状态的包的名称。 null值表示未命名的包为“当前”（请参阅The Java™ Language Specification的第7.4.2节）。
     * enabled - true如果此类加载器加载的类属于命名包或其任何子包，则默认情况下将启用断言， false如果它们默认情况下将禁用断言。
     */
    @Test
    public void setPackageAssertionStatus() {

    }


    /**
     * 为此类加载器中指定的顶级类及其中包含的任何嵌套类设置所需的断言状态。 此设置优先于类加载器的默认断言状态，并优先于任何适用的每个包默认值。 如果已经初始化了命名类，则此方法无效。 （初始化一个类后，其断言状态不会改变。）
     * 如果指定的类不是顶级类，则此调用将不会影响任何类的实际断言状态。
     * <p>
     * 参数
     * className - 要设置其断言状态的顶级类的完全限定类名。
     * enabled - true如果命名类要在初始化时（和如果）初始化时启用断言，则 false如果要禁用断言， false 。
     */
    @Test
    public void setClassAssertionStatus() {

    }


    /**
     * 将此类加载器的默认断言状态设置为false并丢弃与类加载器关联的任何包默认值或类断言状态设置。
     * <p>
     * 提供此方法是为了使类加载器可以忽略任何命令行或持久断言状态设置并“从一个干净的平板开始”
     */
    @Test
    public void clearAssertionStatus() throws ClassNotFoundException {
        ClassLoader classLoader = getClass().getClassLoader();
        classLoader.setDefaultAssertionStatus(true);
        Class cls = classLoader.loadClass("lang.ChinesePeople");
        //实例可以见ClassTest.desiredAssertionStatus Test
        System.out.println(cls.desiredAssertionStatus());
        //重置
        classLoader.clearAssertionStatus();
        System.out.println(cls.desiredAssertionStatus());
    }

}
