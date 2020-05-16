package lang.reflect;

import lang.JDKProxy;
import lang.Person;
import org.junit.Test;

/**
 * @author jujun chen
 * @date 2020/05/13
 */
public class ProxyTest {

    /**
     * 返回指定接口的代理实例
     *
     * 如果违法一下规定，则抛出IllegalArgumentException
     * 给定interfaces数组中的所有类对象必须表示接口，而不是类或基本类型。
     * interfaces数组中两个元素不可以引用相同的类对象。
     * 所有接口类型必须通过指定的类加载器按名称可见。 换句话说，对于类加载器cl和每个接口i ，以下表达式必须为true：
     * Class.forName(i.getName(), false, cl) == i
     * 指定接口的所有公共方法签名引用的所有类型以及由其超接口继承的类型必须通过指定的类加载器按名称可见。
     * 所有非公共接口必须位于同一个包和模块中，由指定的类加载器定义，非公共接口的模块可以访问所有接口类型; 否则，代理类无法实现所有接口，无论它定义在哪个包中。
     * 对于具有相同签名的指定接口的任何成员方法集：
     * 如果任何方法的返回类型是基本类型或void，则所有方法必须具有相同的返回类型。
     * 否则，其中一个方法必须具有可分配给其余方法的所有返回类型的返回类型。
     * 生成的代理类不得超过虚拟机对类强加的任何限制。 例如，VM可以将类可以实现的接口数量限制为65535; 在这种情况下， interfaces阵列的大小不得超过65535。
     */
    @Test
    public void newProxyInstance() {

    }


    /**
     * 如果指定的类是代理类，返回true
     */
    @Test
    public void isProxyClass() {

    }

    /**
     * 返回指定代理实例的调用处理程序
     */
    @Test
    public void getInvocationHandler() {
        
    }

    //todo 目前报错
    @Test
    public void jdkProxyTest() {
        Person person = new Person();
        person.setAge(18);

        JDKProxy jdkProxy = new JDKProxy(person);
        Person proxy = jdkProxy.getProxy();
        System.out.println(proxy.toString());
    }

}

