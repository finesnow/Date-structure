package DesignMode.Adapter;

/**
 * @author Administrator
 * @Date 2025/9/3 10:52
 * @package DesignMode.Adapter
 * @Description: 被代理类 这个类能够帮助解决一部分业务问题
 * 或许让这个类去实现我们的目标接口是个解决方案
 * 但是我们不希望对这个类做任何改动
 */
public class Adaptee {

    public void  AdapteeMethod(){

        System.out.println("Adaptee方法执行部分业务");
    }

}
