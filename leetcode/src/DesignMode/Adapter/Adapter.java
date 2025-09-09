package DesignMode.Adapter;

/**
 * @author Administrator
 * @Date 2025/9/3 09:25
 * @package DesignMode
 * @Description: 继承型适配器类
 */
public class Adapter extends Adaptee implements Target {

    @Override
    public void businessMethod() {
        System.out.println("Adapter业务逻辑1");
        AdapteeMethod();
        System.out.println("Adapter业务逻辑2");
    }

}
