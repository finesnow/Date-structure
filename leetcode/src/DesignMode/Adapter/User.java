package DesignMode.Adapter;

/**
 * @author Administrator
 * @Date 2025/9/3 10:43
 * @package DesignMode.Adapter
 * @Description: 调用者
 */
public class User {

    public static void main(String[] args) {
        //这样做 能够让一个原本不兼容的类为我们工作 当业务逻辑变更时 我们只需要换不同的适配器即可
        //接口与被适配类并不会受影响
        Target target = new Adapter();
        target.businessMethod();
    }
}
