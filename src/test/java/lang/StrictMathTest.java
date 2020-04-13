package lang;

import org.junit.Test;

/**
 * @author jujun chen
 * @date 2020/04/13
 */
public class StrictMathTest {

    /**
     * 返回角度的三角正弦值，如果参数是NaN或无穷大，结果为NaN
     * 如果参数为零，则结果为零，其参数符号相同
     */
    @Test
    public void sin() {
        //Math方法中的正弦值即调用的此类中的方法
        System.out.println(StrictMath.sin(100));
    }

    /**
     * 返回角度的三角余弦值
     * 如果参数是NaN或无穷大，则结果为NaN
     */
    @Test
    public void cos() {
        System.out.println(StrictMath.cos(90));
    }

    /**
     * 返回角度的三角正切
     * 如果参数是NaN或无穷大，则结果为NaN
     * 如果参数为零，则结果为零，其参数符号相同
     */
    @Test
    public void tan() {
        System.out.println(StrictMath.tan(10.3));
    }

    /**
     * 返回值的反正弦值; 返回的角度在-pi/2到pi/2的范围内。
     * 如果参数为NaN或其绝对值大于1，则结果为NaN。
     * 如果参数为零，则结果为零，其参数符号相同。
     */
    @Test
    public void asin() {
        System.out.println(StrictMath.asin(10));
    }

    /**
     * 返回值的反余弦值; 返回的角度在0.0到pi的范围内。 特殊情况：
     * 如果参数为NaN或其绝对值大于1，则结果为NaN。
     */
    @Test
    public void acos() {
        System.out.println(StrictMath.acos(10));
    }

    /**
     * 返回值的反正切值; 返回的角度在-pi / 2到pi / 2的范围内。 特别案例：
     * 如果参数是NaN，则结果为NaN。
     * 如果参数为零，则结果为零，其参数符号相同。
     */
    @Test
    public void atan() {
        System.out.println(StrictMath.atan(10));
    }

    /**
     * 将以度为单位测量的角度转换为以弧度为单位测量的近似等效角度。
     * 从度数到弧度的转换通常是不精确的
     */
    @Test
    public void toRadians() {
        System.out.println(StrictMath.toRadians(90));
    }

    /**
     * 将以弧度测量的角度转换为以度为单位测量的近似等效角度。
     * 从弧度到度数的转换通常是不精确的;
     * 用户不应该指望cos(toRadians(90.0))恰好等于0.0 。
     */
    @Test
    public void toDegrees() {
        System.out.println(StrictMath.toDegrees(0.5));
    }


    //返回绝对值，有double,float,int long
    @Test
    public void abs() {
        System.out.println(StrictMath.abs(-10));
    }


}
