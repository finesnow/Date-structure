package DesignMode.Singleton;

import lombok.Getter;

/**
 * @author Administrator
 * @Date 2025/9/3 20:07
 * @package DesignMode.Singleton
 * @Description: 单例模式 饿汉式  类加载时创建单例对象 线程安全 防止 反序列化 反射破坏
 */
public class Singleton {
    //静态成员变量
    //private static final Singleton singleton = new Singleton();

    private static final Singleton singleton;
    //静态代码块方式实现
    static {
        singleton = new Singleton();
    }

    private Singleton()  {      //防止反射破坏
        if (singleton!=null)
            throw new RuntimeException("禁止重复创建单例对象");
    }

    public static Singleton getInstance() {
        return singleton;
    }

    public Object readResolve() { //防止反序列化破坏
        return getInstance();
    }


}
