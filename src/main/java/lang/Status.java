package lang;

/**
 * 状态枚举
 * @author jujun chen
 * @date 2020/03/20
 */
public enum Status {

    CLOSE("0","停用"),
    OPEN("1","启用");

    private String code;
    private String des;


    Status(String code, String des) {
        this.code = code;
        this.des = des;
    }
}
