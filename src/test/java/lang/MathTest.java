package lang;

import org.junit.Test;

/**
 * @author jujun chen
 * @date 2020/03/29
 */
public class MathTest {

    /**
     * 返回角度的三角正弦值。 特殊情况：
     *      如果参数是NaN或无穷大，则结果为NaN。
     *      如果参数为零，则结果为零，其参数符号相同。
     * 计算结果必须在精确结果的1 ulp范围内。 结果必须是半单调的。
     *
     * 参数
     *      a - 角度，以弧度表示。
     * 结果
     *      正弦。
     */
    @Test
    public void sinTest() {
        double d = Math.sin(100.0);
        System.out.println(d);
        double d1 = Math.sin(1.0/0.0);
        System.out.println(d1);
    }

    /**
     * 返回角度的三角余弦值。 特别：
     *      如果参数是NaN或无穷大，则结果为NaN。
     *      计算结果必须在精确结果的1 ulp范围内。 结果必须是半单调的。
     *
     * 参数
     *      a - 角度，以弧度表示。
     * 结果
     *      余弦
     */
    @Test
    public void cosTest() {
        System.out.println(Math.cos(180));
        System.out.println(Math.cos(1.0/0.0));
    }


    /**
     * 返回角度的三角正切。 特别：
     *      如果参数是NaN或无穷大，则结果为NaN。
     *      如果参数为零，则结果为零，其参数符号相同。
     *      计算结果必须在精确结果的1 ulp范围内。 结果必须是半单调的。
     *
     * 参数
     *      a - 角度，以弧度表示。
     * 结果
     *      参数的正切
     */
    @Test
    public void tanTest() {
        System.out.println(Math.tan(100.0));
        System.out.println(Math.tan(1.0/0.0));
    }


    /**
     * 返回值的反正弦值; 返回的角度在-pi / 2到pi / 2的范围内。 特别：
     * 如果参数为NaN或其绝对值大于1，则结果为NaN。
     * 如果参数为零，则结果为零，其参数符号相同。
     * 计算结果必须在精确结果的1 ulp范围内。 结果必须是半单调的。
     *
     * 参数
     * a - 要返回其正弦值的值
     */
    @Test
    public void asinTest() {
        
    }

    /**
     * 反余弦值
     */
    @Test
    public void acosTest() {

    }

    /**
     * 反正切值
     */
    @Test
    public void atanTest() {

    }

    /**
     * 将以度为单位测量的角度转换为以弧度为单位测量的近似等效角度。
     *
     * 从度数到弧度的转换通常是不精确的。
     *
     * 参数
     *      angdeg - 角度，以度为单位
     * 结果
     *      以弧度为单位测量角度 angdeg
     */
    @Test
    public void toRadiansTest() {
        System.out.println(Math.toRadians(90));
    }


    /**
     * 将以弧度测量的角度转换为以度为单位测量的近似等效角度。
     *
     * 从弧度到度数的转换通常是不精确的; 用户不应该指望cos(toRadians(90.0))恰好等于0.0 。
     * 参数
     *      angrad - 角度，以弧度表示
     * 结果
     *      以度为单位测量角度 angrad
     */
    @Test
    public void toDegrees() {
        System.out.println(Math.toDegrees(1.5707963267948966));
        System.out.println(Math.cos(Math.toDegrees(1.5707963267948966)));
        System.out.println(Math.PI/2);
    }
}
