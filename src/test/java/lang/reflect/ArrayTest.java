package lang.reflect;

import org.junit.Test;

import java.lang.reflect.Array;

/**
 * @author jujun chen
 * @date 2020/05/06
 */
public class ArrayTest {


    @Test
    public void newInstance() {
        /*
         * 创建具有指定类型和长度的数组
         */
        Object object = Array.newInstance(int.class, 10);
        assert object.getClass().isArray();

        Object object1 = Array.newInstance(int.class, 288);
        assert object1.getClass().isArray();

        /**
         * 创建具有指定类型和长度的数组
         * 新数组长度不能超过255，超过抛出java.lang.IllegalArgumentException
         */
        int[] dis = new int[255];
//        int[] dis = new int[256];
        Object object2 = Array.newInstance(int.class, dis);
        assert object2.getClass().isArray();
    }


    /**
     * 返回指定数组对象的长度
     */
    @Test
    public void getLength() {
        int[] dis = new int[255];
        System.out.println(Array.getLength(dis));
    }


    /**
     * 返回指定数组对象中索引组件的值。
     */
    @Test
    public void get() {
        int[] array = new int[]{1, 2};
        Object object = Array.get(array, 0);
        System.out.println(object);
    }


    @Test
    public void getBoolean() {
        boolean[] array = new boolean[]{true, false};
        //java.lang.IllegalArgumentException: Argument is not an array of primitive type
//        Boolean[] array = new Boolean[]{Boolean.TRUE, Boolean.FALSE};
        boolean bl = Array.getBoolean(array, 0);
        System.out.println(bl);
    }

    @Test
    public void getByte() {

    }

    @Test
    public void getChar() {

    }

    @Test
    public void getShort() {

    }

    @Test
    public void getInt() {

    }

    @Test
    public void getLong() {

    }


    @Test
    public void getFloat() {

    }

    @Test
    public void getDouble() {

    }

    /**
     * 将指定数组对象的索引组件的值设置为指定的新值。 如果数组具有基本组件类型，则首先自动解包新值
     */
    @Test
    public void set() {
        int[] array = new int[]{1, 2, 3};
        Integer a = 9;
        Array.set(array, 0, a);
        System.out.println(array[0]);
    }


    @Test
    public void setBoolean() {
        boolean[] array = new boolean[]{true, false};
        Boolean BL = Boolean.FALSE;
        Array.setBoolean(array, 0, BL);
        System.out.println(array[0]);

        //java.lang.IllegalArgumentException: Argument is not an array of primitive type
        //array数组必须是基本类型，但新值可以是包装类型
        /*Boolean[] array2 = new Boolean[]{Boolean.TRUE, Boolean.FALSE};
        boolean bl = false;
        Array.setBoolean(array2, 0 ,bl);
        System.out.println(array2[0]);*/
    }

    @Test
    public void setByte() {

    }

    @Test
    public void setChar() {

    }

    @Test
    public void setShort() {

    }

    @Test
    public void setInt() {

    }

    @Test
    public void setLong() {

    }

    @Test
    public void setFloat() {

    }

    @Test
    public void setDouble() {

    }

}
