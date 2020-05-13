package lang.reflect;

import lang.Person;
import lang.Status;
import org.junit.Test;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.math.BigDecimal;

/**
 * 资料：https://www.shangmayuan.com/a/10368cdcf8a5426a9131160f.html
 *
 * @author jujun chen
 * @date 2020/05/11
 */
public class ParameterTest {
    
    /**
     * 如果参数根据类文件具有名称，则返回true
     * 编译的时候增加 -parameters 参数就能返回true
     * IDEA增加参数的方法：http://www.mamicode.com/info-detail-2162647.html
     * @throws NoSuchMethodException
     */
    @Test
    public void isNamePresent() throws NoSuchMethodException {
        Method method = Person.class.getMethod("setName", String.class);
        Parameter[] parameters = method.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter.getName());
            System.out.println(parameter.isNamePresent());
        }
    }

    /**
     * 返回声明此参数的Executable
     */
    @Test
    public void getDeclaringExecutable() throws NoSuchMethodException {
        Method method = Person.class.getMethod("setStatus", Status.class);
        Executable executable = method.getParameters()[0].getDeclaringExecutable();
        System.out.println(executable.getName());
    }

    /**
     * 获取此Parameter对象表示的参数的修饰符
     */
    @Test
    public void getModifiers() throws NoSuchMethodException {
        Method method = Person.class.getMethod("setStatus", Status.class);
        int mod = method.getParameters()[0].getModifiers();
        System.out.println(Modifier.isFinal(mod));;
    }

    /**
     * 返回参数的名称，如果{@link #isNamePresent()} 返回true,则返回类文件提供的名称，否则，返回argN的名称，N表示方法中声明参数的顺序索引
     */
    @Test
    public void getName() throws NoSuchMethodException {
        Method method = Person.class.getMethod("setStatus", Status.class);
        System.out.println(method.getParameters()[0].getName());;
    }

    /**
     * 返回表示此参数对象的参数化类型Type对象
     */
    @Test
    public void getParameterizedType() throws NoSuchMethodException {
        Method method = Person.class.getMethod("setStatus", Status.class);
        Type type = method.getParameters()[0].getParameterizedType();
        System.out.println(type.getTypeName());
    }

    /**
     * 返回表示此参数的声明类型的类对象
     */
    @Test
    public void getType() throws NoSuchMethodException {
        Method method = Person.class.getMethod("setStatus", Status.class);
        Class cls = method.getParameters()[0].getType();
        System.out.println(cls.getName());
    }


    /**
     * 返回此参数的声明类型，用AnnotatedType对象表示
     * @throws NoSuchMethodException
     */
    @Test
    public void getAnnotatedType() throws NoSuchMethodException {
        Method method = Person.class.getMethod("setStatus", Status.class);
        AnnotatedType annotatedType = method.getParameters()[0].getAnnotatedType();
    }

    /**
     * 如果此参数是隐式声明的，返回true
     * https://blog.csdn.net/zsk1196468672/article/details/51628145
     */
    @Test
    public void isImplicit() throws NoSuchMethodException {
        Method method = Person.class.getMethod("setStatus", Status.class);
        boolean bl = method.getParameters()[0].isImplicit();
        System.out.println(bl);

        //java 编译器会为内部类的构造方法建立一个隐式参数
        Constructor<InnerClass> constructor = InnerClass.class.getConstructor(ParameterTest.class, String.class);
        Parameter[] parameters = constructor.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter + " -> " + parameter.isImplicit());
        }
    }

    class InnerClass {
        public InnerClass(String key) {
        }
    }

}
