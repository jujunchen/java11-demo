package lang;

import java.beans.JavaBean;
import java.lang.annotation.Documented;

/**
 * @author jujun chen
 * @date 2020/03/01
 */
@JavaBean(description = "Person.class")
@Name
@Car
public class Person implements Animal{
    public String name;
    public int age;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("name=" + name);
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
