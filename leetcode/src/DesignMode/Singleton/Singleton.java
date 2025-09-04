package DesignMode.Singleton;

/**
 * @author Administrator
 * @Date 2025/9/3 20:07
 * @package DesignMode.Singleton
 * @Description: 单例模式
 */
public class Singleton {
    private static final Singleton singleton = new Singleton();
    private Singleton() {

    }
    public static Singleton getSingleton() {
        return singleton;
    }
}
