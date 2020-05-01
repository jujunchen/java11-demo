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
    
    @Test
    public void setAccessible() throws IllegalAccessException {
        //对数组中的每个元素这只accessible标志
        Person person = new Person();
        person.setAddress("浙江杭州");
        Field[] fields = person.getClass().getDeclaredFields();
        //没有设置ture，获取address 字段时将报IllegalAccessException
        AccessibleObject.setAccessible(fields, true);
        for (Field field : fields) {
            System.out.println(field.get(person));
        }
    }
}
