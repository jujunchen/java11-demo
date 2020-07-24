package lang;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

/**
 * @author jujun chen
 * @date 2020/04/02
 */
public class PackageTest {

    ClassLoader classLoader = PackageTest.class.getClassLoader();

    /**
     * 返回此包的名称
     */
    @Test
    public void getName() {
        Package pk = Package.getPackage("java.lang");
        Package[] packages = Package.getPackages();
        System.out.println(pk.getName());
    }

    /**
     * 返回此包的规范标题
     */
    @Test
    public void getSpecificationTitle() {
        Package pk = classLoader.getDefinedPackage("lang");
        System.out.println(pk.getSpecificationTitle());
    }

    /**
     * 返回此包规范的版本号
     */
    @Test
    public void getSpecificationVersion() {
        Package pk = classLoader.getDefinedPackage("lang");
        System.out.println(pk.getSpecificationVersion());
    }

    /**
     * 返回拥有并维护此包的组织
     */
    @Test
    public void getSpecificationVendor() {
        Package pk = Package.getPackage("java.lang");
        System.out.println(pk.getSpecificationVendor());
    }

    /**
     * 返回此包的标题
     */
    @Test
    public void getImplementationTitle() {
        Package pk = classLoader.getDefinedPackage("lang");
        System.out.println(pk.getImplementationTitle());
    }

    /**
     * 返回实现版本
     */
    @Test
    public void getImplementationVersion() {
        Package pk = Package.getPackage("java.lang");
        System.out.println(pk.getImplementationVersion());
    }


    /**
     * 返回实现的组织
     */
    @Test
    public void getImplementationVendor() {

    }

    @Test
    public void isSealed() throws MalformedURLException {
        /**
         * 该包是否已密封
         *
         * 如果包装是密封的，则为true，否则为false
         */
        Package pk = Package.getPackage("lang");
        System.out.println(pk.isSealed());

        Package pk2 = Package.getPackage("java.lang");
        System.out.println(pk2.isSealed());

        /*
        如果此包相对于指定的代码源 url密封，则返回true
         */
        Package pk3 = Package.getPackage("java.lang");
        System.out.println(pk3.isSealed(new URL("http://www.baidu.com")));
    }

    /**
     * 将此软件包的规范版本与所需版本进行比较。 如果此包规范版本号大于或等于所需的版本号，则返回true。
     * <p>
     * 通过顺序地比较期望和规范字符串的相应组件来比较版本号。 每个组件都转换为十进制整数并比较值。
     * <p>
     * 如果规范值大于期望值，则返回true。 如果值小于false则返回。 如果值相等，则跳过周期并比较下一对组件。
     * <p>
     * 参数
     * desired - 所需版本的版本字符串。
     * 结果
     * 如果此程序包的版本号大于或等于所需的版本号，则为true
     */
    @Test
    public void isCompatibleWith() {

    }

    /**
     * 回调用者的类加载器及其祖先定义的所有软件包 。
     * 返回的数组可能包含多个具有相同包名称的软件包对象，每个对象都由类加载器层次结构中的不同类加载器定义。
     * 调用此方法相当于在ClassLoader实例上调用ClassLoader.getPackages() ，该实例是调用者的类加载器。
     * <p>
     * 结果
     * 由此类加载器及其祖先定义的 软件包对象的数组
     */
    @Test
    public void getPackages() {
        Package[] packages = Package.getPackages();
        System.out.println(Arrays.asList(packages));
    }


    /**
     * 返回指定类型的注解，没有返回null
     */
    @Test
    public void getAnnotation() {

    }


    /**
     * 存在指定类型的注解，返回true
     */
    @Test
    public void isAnnotationPresent() {

    }

    /**
     * 返回指定类型的注解，数组类型
     */
    @Test
    public void getAnnotationsByType() {

    }

    /**
     * 返回此元素上存在的注解
     */
    @Test
    public void getAnnotations() {

    }


    /**
     * 返回指定类型的注解，忽略父注解
     */
    @Test
    public void getDeclaredAnnotation() {

    }


    /**
     * 返回指定类型的注解，数组类型,忽略父注解
     */
    @Test
    public void getDeclaredAnnotationsByType() {

    }

    /**
     * 返回此元素上存在的注解，忽略父注解
     */
    @Test
    public void getDeclaredAnnotations() {

    }

}
