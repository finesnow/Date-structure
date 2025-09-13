package TestDemos;

/**
 * @author Administrator
 * @Date 2025/8/28 20:58
 * @package Test
 * @Description: 枚举类模拟
 */
public class Enum {

    //公共常量 到处都可以访问，不能被修改
    public static final Enum ENUM1 = new Enum("一号枚举", 1);
    public static final Enum ENUM2 = new Enum("二号枚举", 2);
    private String name;
    private int size;


    //通过这种方式，我们严格限制了Enum类的对象数量，并且每个已经存在的对象都是容易访问或使用的

    //构造方法私有，禁止外界创建新对象
    //没有set方法 防止属性被修改
    private Enum(String name, int size) {
        this.name = name;
        this.size = size;
    }
    private Enum() {
    }

}
