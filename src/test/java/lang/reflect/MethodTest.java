package lang.reflect;

import lang.Person;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

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
    
    @Test
    public void getTypeParameters() throws NoSuchMethodException {
        Method method = Person.class.getMethod("setName", String.class);
        TypeVariable[] typeVariables = method.getTypeParameters();
        System.out.println(typeVariables.length);
    }


}
