package lang;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author jujun chen
 * @date 2020/03/25
 */
public class FloatTest {

    @Test
    public void toString1() {
        //概念Double
    }

    @Test
    public void toHexString() {
        //概念同Double
    }


    @Test
    public void valueOf() {
        /*
        返回Float对象，其中float由参数字符串s表示的float值。
        如果s是null ，则抛出NullPointerException 。
         */
        System.out.println(Float.valueOf("1.2"));
        System.out.println(Float.valueOf("1.2f"));
        //抛出NPE
//        System.out.println(Float.valueOf(null));

        float f = (float) 1.2;
        System.out.println(Float.valueOf(1.2f));
        System.out.println(Float.valueOf(f));
    }


    /**
     * 返回一个新 float初始化为指定的代表的值 String ，如通过执行 valueOf类的方法 Float
     */
    @Test
    public void parseFloat() {
        float f = Float.parseFloat("1.2");
        //抛错
//        assert f == 1.2;
        assert f == 1.2f;
    }


    /**
     * 两个float相加
     */
    @Test
    public void sum() {
        System.out.println(Float.sum(1.2f, 1f));
        System.out.println(Float.sum(1.2f, 1));
    }


    /**
     * 返回两个float中较大一个
     */
    @Test
    public void max() {
        System.out.println(Float.max(1.2f, 1f));
    }


    /**
     * 返回两个float中较小一个
     */
    @Test
    public void min() {
        System.out.println(Float.min(1.2f, 1f));
    }


    /**
     * 返回Float的byte值
     */
    @Test
    public void byteValue() {
        Float f = 0.1f;
        byte fb = f.byteValue();
        System.out.println(fb);
    }



}
