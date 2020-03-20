package lang;

/**
 * @author jujun chen
 * @date 2020/03/01
 */
@Name
public class ChinesePeople extends Person {

    static {
        System.out.println("加载类");
    }

    public ChinesePeople() {
        System.out.println("实例化类，我是中国人");
    }

    public ChinesePeople(String name) {
        System.out.println(name + "，我是中国人");
    }

    public class ZjPeople {

    }
}
