/**
 * @author: jujun chen
 * @description:
 * @date: 2020/05/20
 */
module userfuncsimp {
    requires userfuncs;


    //不可或缺
    provides userfuncs.binaryfuncs.BinFuncProvider with
            userfuncsimp.binaryfuncsimp.AbsPlusProvider,
            userfuncsimp.binaryfuncsimp.AbsMinusProvider;
}