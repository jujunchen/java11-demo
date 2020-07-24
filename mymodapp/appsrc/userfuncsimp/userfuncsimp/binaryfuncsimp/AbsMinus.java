package userfuncsimp.binaryfuncsimp;

import userfuncs.binaryfuncs.BinaryFunc;

/**
 * 两数绝对值之差的实现
 *
 * @author jujun chen
 * @date 2020/05/20
 */
public class AbsMinus implements BinaryFunc {
    /**
     * 函数名称获取
     *
     * @return
     */
    @Override
    public String getName() {
        return "AbsMinus";
    }

    /**
     * 函数实现
     *
     * @param a
     * @param b
     * @return
     */
    @Override
    public int func(int a, int b) {
        return Math.abs(a) - Math.abs(b);
    }
}
