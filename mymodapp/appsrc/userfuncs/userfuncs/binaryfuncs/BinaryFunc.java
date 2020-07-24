package userfuncs.binaryfuncs;

/**
 * 服务接口
 *
 * @author jujun chen
 * @date 2020/05/20
 */
public interface BinaryFunc {

    /**
     * 函数名称获取
     *
     * @return
     */
    public String getName();

    /**
     * 函数实现
     *
     * @param a
     * @param b
     * @return
     */
    public int func(int a, int b);
}
