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

    /**
     * 返回欧拉数e为底的双精度值次幂。特殊情况：
     * 	如果参数为NaN，那么结果为NaN。
     * 	如果参数为正无穷大，那么结果为正无穷大。
     * 	如果参数为负无穷大，那么结果是正零。
     * 	计算结果必须在1 ulp 的确切结果。结果必须具有半单调。
     */
    @Test
    public void expTest() {
        double d = Math.exp(2);
        System.out.println(d);
    }


    /**
     * 返回double值的自然对数（基数e ）。 特殊情况：
     * 如果参数为NaN或小于零，则结果为NaN。
     * 如果参数是正无穷大，那么结果是正无穷大。
     * 如果参数为正零或负零，则结果为负无穷大。
     * 计算结果必须在精确结果的1 ulp范围内。 结果必须是半单调的
     */
    @Test
    public void logTest() {
        double d = Math.log(4);
        System.out.println(d);
    }


    /**
     * 返回double值的基数10对数。 特殊情况：
     * 如果参数为NaN或小于零，则结果为NaN。
     * 如果参数是正无穷大，那么结果是正无穷大。
     * 如果参数为正零或负零，则结果为负无穷大。
     * 如果参数等于10 n，用于整数n，则结果为n。
     * 计算结果必须在精确结果的1 ulp范围内。 结果必须是半单调的。
     *
     * 参数
     * a - 一个值
     * 结果
     * 基数为10的对数为 a 
     */
    @Test
    public void log10Test() {
        double d = Math.log10(100);
        System.out.println(d);
    }


    /**
     * 返回double值的正确舍入的正平方根。 特殊情况：
     * 如果参数为NaN或小于零，则结果为NaN。
     * 如果参数是正无穷大，那么结果是正无穷大。
     * 如果参数为正零或负零，则结果与参数相同。
     * 否则，结果是最接近参数值的真数学平方根的double值。
     * 参数
     * a - 一个值。
     * 结果
     * 正方根a 。 如果参数为NaN或小于零，则结果为NaN
     */
    @Test
    public void sqrtTest() {
        System.out.println(Math.sqrt(4));
        System.out.println(Math.sqrt(6));
    }


    /**
     * 返回double值的立方根，特殊情况
     *  如果参数是NaN，则结果为NaN。
     *  如果参数是无穷大，则结果是无穷大，其符号与参数相同。
     *  如果参数为零，则结果为零，其参数符号相同。
     *  计算结果必须在精确结果的1 ulp范围内
     */
    @Test
    public void cbrtTest() {
        System.out.println(Math.cbrt(27));
    }


    /**
     * 根据IEEE 754标准规定，计算两个参数的余数运算。 余数的算术值等于f1 - f2 x n，其中n是最接近商的精确算术值的数学整数f1/f2 ，并且如果两个整数都同样接近f1/f2 ，那么n是其中的偶数。
     * 如果余数为零，则其符号与第一个参数的符号相同。 特别案例：
     * 如果任一参数为NaN，或者第一个参数为无穷大，或者第二个参数为正零或负零，则结果为NaN。
     * 如果第一个参数是有限的，第二个参数是无限的，那么结果与第一个参数相同。
     * 参数
     * f1 - 股息。
     * f2 - 除数
     * 结果
     * 当 f1除以 f2时的余数
     */
    @Test
    public void IEEEremainder() {
        System.out.println(Math.IEEEremainder(10,6));
    }

    /**
     * 返回大于或等于参数且等于最小整数的double值，特殊情况
     *  如果参数值已经等于数学整数，则结果与参数相同。
     *  如果参数为NaN或无穷大或正零或负零，则结果与参数相同。
     *  如果参数值小于零但大于-1.0，则结果为负零。
     *  需要注意的是Math.ceil(x)正是-Math.floor(-x)
     */
    @Test
    public void ceilTest() {
        System.out.println(Math.ceil(3.1));
    }

    /**
     * 返回小于或等于参数且等于数学整数的最大值（最接近正无穷大） double 。 特别：
     *      如果参数值已经等于数学整数，则结果与参数相同。
     *      如果参数为NaN或无穷大或正零或负零，则结果与参数相同。
     * 参数
     *      a - 一个值。
     * 结果
     *      最大（最接近正无穷大）浮点值，小于或等于参数且等于数学整数
     */
    @Test
    public void floorTest() {
        System.out.println(-Math.floor(-3.1));
    }

    /**
     * 返回与double值最接近的double值，该值等于数学整数。
     * 如果两个double是数学整数的值同样接近，则结果是偶数的整数值。 特殊情况：
     *      如果参数值已经等于数学整数，则结果与参数相同。
     *      如果参数为NaN或无穷大或正零或负零，则结果与参数相同。
     * 参数
     *      a - 值 double 。
     * 结果
     *      最接近 a浮点值，等于数学整数
     */
    @Test
    public void rintTest() {
        assert Math.rint(3.1) == 3.0;
        assert Math.rint(3.4) == 3.0;
        assert Math.rint(3.5) == 4.0;
    }

}
