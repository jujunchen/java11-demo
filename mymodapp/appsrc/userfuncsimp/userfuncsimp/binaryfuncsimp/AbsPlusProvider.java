package userfuncsimp.binaryfuncsimp;

import userfuncs.binaryfuncs.BinFuncProvider;
import userfuncs.binaryfuncs.BinaryFunc;

/**
 * AbsPlus提供者，返回了AbsPlus实例
 * @author jujun chen
 * @date 2020/05/20
 */
public class AbsPlusProvider implements BinFuncProvider {
    /**
     * 获取BinaryFunc实例
     *
     * @return
     */
    @Override
    public BinaryFunc get() {
        return new AbsPlus();
    }
}
