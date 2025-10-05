package DesignMode.Singleton;

/**
 * @author Administrator
 * @date 2025/9/14 09:57
 * @see
 * @since JDK 17
 *  懒汉式单例模式 在使用时才创建对象  需要加锁确保线程安全
 */
public class Singleton2 {

    private static volatile Singleton2 singleton;

    private Singleton2() {

    }

    public static  Singleton2 getInstance() {
        if (singleton==null)
            {
                synchronized (Singleton2.class){
                    if (singleton==null)
                    {
                        singleton = new Singleton2();
                    }
                }
            }
        return singleton;
    }

    public Object readResolve() { //防止反序列化破坏
        return getInstance();
    }

}
