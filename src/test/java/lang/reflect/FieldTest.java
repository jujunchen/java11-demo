package lang.reflect;

import lang.ClassTest;
import lang.Person;
import lang.Status;
import org.junit.Test;

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
     * @throws NoSuchFieldException
     */
    @Test
    public void getGenericType() throws NoSuchFieldException {
        Type type = Person.class.getDeclaredField("status").getGenericType();
        System.out.println(type.getTypeName());
    }
}
