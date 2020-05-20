/**
 * @author: jujun chen
 * @description:
 * @date: 2020/05/17
 */
module appstart {
    requires appfuncs;
    requires userfuncs;

    //声明使用BinFuncProvider
    uses userfuncs.binaryfuncs.BinFuncProvider;
}