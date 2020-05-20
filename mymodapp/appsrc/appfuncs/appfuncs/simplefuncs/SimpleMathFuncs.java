package appfuncs.simplefuncs;

import static appsupport.supportfuncs.SupportFuncs.isFactor;

/**
 * @author jujun chen
 * @date 2020/05/17
 */
public class SimpleMathFuncs {

    public static int lcf(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        int min = a < b ? a : b;

        for (int i = 2; i < min/2; i++) {
            if (isFactor(i, a) && isFactor(i, b))
                return i;
        }

        return 1;
    }

    public static int gcf(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        int min = a < b ? a : b;

        for (int i = min/2; i >= 2; i--) {
            if (isFactor(i, a) && isFactor(i, b))
                return i;
        }

        return 1;
    }
}
