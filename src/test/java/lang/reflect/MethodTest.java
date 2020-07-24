package lang.reflect;

import lang.ClassTest;
import lang.Person;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.List;

/**
 * @author jujun chen
 * @date 2020/05/08
 */
public class MethodTest {

    /**
     * @see AccessibleObjectTest#setAccessible()
     */
    @Test
    public void setAccessible() {

    }

    /**
     * 返回声明类
     *
     * @see FieldTest#getDeclaringClass()
     */
    @Test
    public void getDeclaringClass() {
        Method[] methods = Person.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getDeclaringClass());
        }
    }

    /**
     * 返回方法的名称
     */
    @Test
    public void getName() {
        Method[] methods = Person.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

    /**
     * 返回表示泛型的变量名称
     *
     * @throws NoSuchMethodException
     */
    @Test
    public void getTypeParameters() throws NoSuchMethodException {
        Method method = Person.class.getMethod("getName");
        TypeVariable[] typeVariables = method.getTypeParameters();
        System.out.println(typeVariables[0]);
    }

    /**
     * 表示方法的返回类型
     */
    @Test
    public void getReturnType() throws NoSuchMethodException {
        Class cls = Person.class.getMethod("getName").getReturnType();
        System.out.println(cls.getName());
    }

    /**
     * 返回一个Type对象，该对象表示此方法对象表示的方法的正式返回类型
     */
    @Test
    public void getGenericReturnType() throws NoSuchMethodException {
        Type type = Person.class.getMethod("getName").getGenericReturnType();
        System.out.println(type.getTypeName());
    }

    /**
     * 返回此对象表示的可执行文件的形式参数（无论是显式声明还是隐式声明，或两者都不
     */
    @Test
    public void getParameterCount() throws NoSuchMethodException {
        int count = Person.class.getMethod("setName", String.class).getParameterCount();
        System.out.println(count);
    }

    /**
     * 返回一个Type对象的数组， Type对象表示此对象所表示的可执行文件的声明顺序的形式参数类型。
     * 如果底层可执行文件不带参数，则返回长度为0的数组
     */
    @Test
    public void getGenericParameterTypes() throws NoSuchMethodException {
        Type[] types = Person.class.getMethod("setName", String.class).getGenericParameterTypes();
        System.out.println(Arrays.toString(types));
    }

    /**
     * 返回一个Type对象的数组， Type对象表示声明由此可执行对象引发的异常。
     * 如果底层可执行文件在其throws子句中未声明异常，则返回长度为0的数组
     */
    @Test
    public void getGenericExceptionTypes() throws NoSuchMethodException {
        Type[] types = MethodTest.class.getMethod("getGenericParameterTypes").getGenericExceptionTypes();
        System.out.println(Arrays.toString(types));
    }


    /**
     * 在具有指定参数的指定对象上调用此方法对象表示的基础方法。 各个参数自动展开以匹配原始形式参数，并且原始参数和参考参数都根据需要进行方法调用转换。
     * 如果基础方法是静态的，则忽略指定的obj参数。 它可能为空。
     * <p>
     * 如果基础方法所需的形式参数的数量为0，则提供的args数组的长度可以为0或null。
     * <p>
     * 如果底层方法是实例方法，则使用动态方法查找调用它，如Java语言规范第15.12.4.4节中所述; 特别地，可能发生基于目标对象的运行时类型的覆盖。
     * <p>
     * 如果底层方法是静态的，则声明该方法的类如果尚未初始化则初始化。
     * <p>
     * 如果方法正常完成，则返回的值返回给invoke的调用者; 如果值具有基本类型，则首先将其适当地包装在对象中。 但是，如果值具有基本类型数组的类型，则数组的元素不会包装在对象中; 换句话说，返回一个原始类型的数组。
     * 如果底层方法返回类型为void，则调用返回null。
     * <p>
     * 参数
     * obj - 从中调用基础方法的对象
     * args - 用于方法调用的参数
     * 结果
     * 调度此对象表示的方法的结果在 obj ，参数为 args
     */
    @Test
    public void invoke() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person person = new Person();
        person.setName("xxx");

        Object object = person.getClass().getMethod("getName").invoke(person);
        System.out.println(object);
    }


    /**
     * 如果此方法是桥接方法，则返回true ; 否则返回false 。
     * 结果
     * 当且仅当此方法是Java语言规范定义的桥接方法时才返回true。
     */
    @Test
    public void isBridge() {

    }

    /**
     * 如果声明此可执行文件采用可变数量的参数，则返回true ; 否则返回false 。
     * 重写：
     * isVarArgs在类 Executable
     * 结果
     * true如果仅在声明此可执行文件时采用可变数量的参数。
     */
    @Test
    public void isVarArgs() {

    }


    /**
     * 如果此可执行文件是合成构造，则返回true ; 否则返回false
     */
    @Test
    public void isSynthetic() {

    }

    /**
     * 如果此方法是默认方法，则返回true ; 否则返回false 。 默认方法是公共非抽象实例方法，即具有主体的非静态方法，在接口类型中声明。
     * 结果
     * 当且仅当此方法是Java语言规范定义的默认方法时才返回true
     */
    @Test
    public void isDefault() {

    }


    /**
     * 返回此方法实例表示的注解成员的默认值。
     * 如果成员是基本类型，则返回相应包装类型的实例。
     * 如果没有与成员关联的默认值，或者方法实例不表示注解类型的声明成员，则返回null。
     * 结果
     * 此 方法实例表示的注解成员的默认值。
     */
    @Test
    public void getDefaultValue() {

    }


    /**
     * 返回该元素的，如果这样的注解 ，否则返回null指定类型的注解
     */
    @Test
    public void getAnnotation() {

    }

    /**
     * 返回直接出现在此元素上的注解。 此方法忽略继承的注解
     */
    @Test
    public void getDeclaredAnnotations() {

    }

    /**
     * 返回参数上的注解，返回二维数组
     */
    @Test
    public void getParameterAnnotations() {

    }

    /**
     * 方法返回的类型对象，使用AnnotatedType表示
     */
    @Test
    public void getAnnotatedReturnType() {

    }

}
