package lang;

import java.beans.JavaBean;
import java.util.Objects;

/**
 * @author jujun chen
 * @date 2020/03/01
 */
@JavaBean(description = "Person.class")
@Name
@Car
public class Person implements Animal {
    public String name;
    public int age;
    private String address;
    Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public <F> String getName() {
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return 111;
    }
}
