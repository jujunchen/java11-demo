package lang;

import org.junit.Test;

/**
 * @author jujun chen
 * @date 2020/03/29
 */
public class ObjectTest {

    /**
     * 浅拷贝，如果属性是引用类型，并不生成新引用
     *
     * @throws CloneNotSupportedException
     */
    @Test
    public void cloneTest() throws CloneNotSupportedException {
        Car car = new Car();
        Wheel wheel = new Wheel();
        wheel.setSize(13);
        car.setWheel(wheel);
        System.out.println("修改前：car=" + car);

        Car car1 = (Car) car.clone();
        System.out.println("修改前：car1=" + car1);

        car1.getWheel().setSize(13.5);

//        Wheel wheel1 = new Wheel();
//        wheel1.setSize(15);
//        car1.setWheel(wheel1);

        System.out.println("修改后：car=" + car);
        System.out.println("修改后：car1=" + car1);
    }

    static class Car implements Cloneable {
        private Wheel wheel;

        public Wheel getWheel() {
            return wheel;
        }

        public void setWheel(Wheel wheel) {
            this.wheel = wheel;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return "Car{" +
                    "wheel=" + wheel +
                    '}';
        }
    }

    static class Wheel implements Cloneable {
        private double size;

        public double getSize() {
            return size;
        }

        public void setSize(double size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return "Wheel{" +
                    "size=" + size +
                    '}';
        }
    }
}
