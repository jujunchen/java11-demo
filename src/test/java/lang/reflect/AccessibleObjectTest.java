package lang.reflect;

import lang.Person;
import org.junit.Test;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/**
 * @author jujun chen
 * @date 2020/05/01
 */
public class AccessibleObjectTest {

    /**
     * 设置为ture用于方法反射对象的私有属性
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    @Test
    public void setAccessible() throws IllegalAccessException, NoSuchFieldException {
        //对数组中的每个元素这只accessible标志
        Person person = new Person();
        person.setAddress("浙江杭州");
        Field[] fields = person.getClass().getDeclaredFields();
        //没有设置ture，获取address 字段时将报IllegalAccessException
        AccessibleObject.setAccessible(fields, true);
        for (Field field : fields) {
            System.out.println(field.get(person));
        }

        Person person1 = new Person();
        person1.setAddress("绍兴诸暨");
        Field field = person1.getClass().getDeclaredField("address");
        field.setAccessible(true);
        System.out.println(field.get(person1));
    }


    /**
     * 尝试设置反射对象，如果设置成功返回true
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void trySetAccessible() throws NoSuchFieldException, IllegalAccessException {
        Person person1 = new Person();
        person1.setAddress("绍兴诸暨");
        Field field = person1.getClass().getDeclaredField("address");
        if (field.trySetAccessible()) {
            System.out.println(field.get(person1));
        } else {
            System.out.println("111");
        }
    }


    /**
     * 测试反射对象能否设置accessible
     * @throws NoSuchFieldException
     */
    @Test
    public void canAccess() throws NoSuchFieldException {
        Person person1 = new Person();
        person1.setAddress("绍兴诸暨");
        Field field = person1.getClass().getDeclaredField("address");
        //未设置，无法访问私有属性
        field.setAccessible(true);
        System.out.println(field.canAccess(person1));
    }
}
