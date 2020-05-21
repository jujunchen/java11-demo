package userfuncsimp.binaryfuncsimp;

import userfuncs.binaryfuncs.BinFuncProvider;
import userfuncs.binaryfuncs.BinaryFunc;

/**
 * AbsMinus提供者，返回了AbsMinus实例
 * @author jujun chen
 * @date 2020/05/20
 */
public class AbsMinusProvider implements BinFuncProvider {
    /**
     * 获取BinaryFunc实例
     *
     * @return
     */
    @Override
    public BinaryFunc get() {
        return new AbsMinus();
    }
}
