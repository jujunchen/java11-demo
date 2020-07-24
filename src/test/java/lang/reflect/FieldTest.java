package lang.reflect;

import lang.ClassTest;
import lang.Person;
import lang.Status;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * @author jujun chen
 * @date 2020/05/07
 */
public class FieldTest {

    /**
     * 返回字段的声明类
     */
    @Test
    public void getDeclaringClass() throws NoSuchFieldException {
        Person person = new Person();
        Class cls = person.getClass().getDeclaredField("status").getDeclaringClass();
        //lang.Person
        System.out.println(cls.getName());
    }

    /**
     * 以整数形式返回此字段对象表示的字段的Java语言修饰符。 应该使用Modifier类来解码修饰符
     *
     * @see java.lang.reflect.Modifier
     */
    @Test
    public void getModifiers() throws NoSuchFieldException {
        Person person = new Person();
        int publicModifier = person.getClass().getDeclaredField("name").getModifiers();
        int privateModifier = person.getClass().getDeclaredField("status").getModifiers();
        System.out.println(publicModifier);
        System.out.println(privateModifier);
    }


    /**
     * 如果此字段表示枚举类型的元素，则返回true ; 否则返回false
     */
    @Test
    public void isEnumConstant() throws NoSuchFieldException {
        boolean bl = Status.class.getDeclaredField("CLOSE").isEnumConstant();
        System.out.println(bl);
    }

    /**
     * 判断字段是否是合成字段
     * http://blog.sina.com.cn/s/blog_1534f339a0102y88n.html
     */
    @Test
    public void isSynthetic() {

    }

    /**
     * 获取字段的声明类型
     *
     * @throws NoSuchFieldException
     */
    @Test
    public void getType() throws NoSuchFieldException {
        Class cls = Person.class.getDeclaredField("status").getType();
        //lang.Status
        System.out.println(cls.getName());
    }

    /**
     * 返回一个Type对象，该对象表示此字段对象表示的字段的声明类型
     *
     * @throws NoSuchFieldException
     */
    @Test
    public void getGenericType() throws NoSuchFieldException {
        Type type = Person.class.getDeclaredField("status").getGenericType();
        System.out.println(type.getTypeName());
    }

    /**
     * 返回指定对象上此字段表示的字段的值。 如果对象具有基本类型，则该值自动包装在对象中。
     *
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void get() throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person();
        person.setName("xxx");
        Object object = Person.class.getField("name").get(person);
        System.out.println(object);

        person.setAge(100);
        Long age = Person.class.getField("age").getLong(person);
        System.out.println(age);

        person.setAddress("浙江绍兴");
        Field addressField = Person.class.getDeclaredField("address");
        addressField.setAccessible(true);
        Object address = addressField.get(person);
        System.out.println(address);
    }


    /**
     * 将指定对象参数上此字段对象表示的字段设置为指定的新值。 如果基础字段具有基本类型，则新值将自动解包。
     * 该操作如下：
     * <p>
     * 如果基础字段是静态的，则忽略obj参数; 它可能是null。
     * <p>
     * 否则，基础字段是实例字段。 如果指定的对象参数为null，则该方法抛出NullPointerException 。
     * 如果指定的对象参数不是声明基础字段的类或接口的实例，则该方法将抛出IllegalArgumentException 。
     * <p>
     * 如果此字段对象强制执行Java语言访问控制，并且基础字段不可访问，则该方法将抛出IllegalAccessException 。
     * <p>
     * 如果基础字段为final，则该方法抛出IllegalAccessException除非setAccessible(true)已成功执行此字段对象且该字段为非静态字段。
     * 以这种方式设置最终字段仅在反序列化或重建具有空白最终字段的类的实例期间才有意义，然后才能使程序的其他部分访问它们。 在任何其他上下文中使用可能具有不可预测的影响，包括程序的其他部分继续使用该字段的原始值的情况。
     * <p>
     * 如果基础字段是基本类型，则尝试进行解包转换以将新值转换为基本类型的值。 如果此尝试失败，则该方法抛出IllegalArgumentException 。
     * <p>
     * 如果在可能的解包之后，新值无法通过标识或扩展转换转换为基础字段的类型，则该方法将抛出IllegalArgumentException 。
     * <p>
     * 如果基础字段是静态的，则声明该字段的类如果尚未初始化则初始化。
     * <p>
     * 该字段设置为可能未展开和加宽的新值。
     * <p>
     * 如果该字段隐藏在obj类型中，则根据前面的规则设置字段的值。
     */
    @Test
    public void set() {

    }

}
