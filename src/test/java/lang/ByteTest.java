package lang;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jujun chen
 * @date 2020/02/29
 */
public class ByteTest {

    @Test
    public void decodeTest() {
        //10进制
        Byte code = Byte.decode("10");
        assert code == 10;
        //16进制
        Byte code1 = Byte.decode("0x10");
        assert code1 == 16;
        //16进制
        Byte code2 = Byte.decode("#10");
        assert code2 == 16;
        //8进制
        Byte code3 = Byte.decode("010");
        assert code3 == 8;

        //使用radix=8进制转换10
        byte byte1 = Byte.parseByte("10",8);
        assert byte1 == 8;

        byte byte2 = Byte.valueOf("10",8);
        assert byte2 == 8;
    }
}
