package appstart.mymodappdemo;

import appfuncs.simplefuncs.SimpleMathFuncs;
import userfuncs.binaryfuncs.BinFuncProvider;
import userfuncs.binaryfuncs.BinaryFunc;

import java.util.ServiceLoader;

/**
 * @author jujun chen
 * @date 2020/05/17
 */
public class MyModAppDemo {

    public static void main(String[] args) {
        if (SimpleMathFuncs.isFactor(2, 10))
            System.out.println("2 is a factor of 10");

        System.out.println("Smallest factor common to both 35 and 105 is " + SimpleMathFuncs.lcf(35, 105));

        System.out.println("Largest factor common to both 35 and 105 is " + SimpleMathFuncs.gcf(35, 105));

        //使用ServiceLoader加载服务，测试发现并没有找到实现类//todo
        ServiceLoader<BinFuncProvider> ldr = ServiceLoader.load(BinFuncProvider.class);

        BinaryFunc binOp = null;

        //查找绝对值相加的程序
        for (BinFuncProvider bfp : ldr) {
            if (bfp.get().getName().equals("AbsPlus")) {
                binOp = bfp.get();
                break;
            }
        }

        if (binOp != null) {
            System.out.println("Result of AbsPlus function: " + binOp.func(12, -4));
        } else {
            System.out.println("AbsPlus function not found");
        }

        binOp = null;

        //找到绝对值相减的程序
        for (BinFuncProvider bfp : ldr) {
            if (bfp.get().getName().equals("AbsMinus")) {
                binOp = bfp.get();
                break;
            }
        }

        if (binOp != null) {
            System.out.println("Result of AbsMinus function: " + binOp.func(12, -4));
        } else {
            System.out.println("AbsMinus function not found");
        }
    }
}
