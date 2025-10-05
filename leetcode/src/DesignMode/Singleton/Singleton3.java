package DesignMode.Singleton;

/**
 * @author Administrator
 * @date 2025/9/14 10:31
 * @see
 * @since JDK 17 懒汉式3 静态内部类
 */
public class Singleton3 {

    private Singleton3() {
        if (SingletonHolder.flag)
            throw  new RuntimeException("非法访问");
    }
    private static class SingletonHolder{
        private static final Singleton3 INSTANCE ;
        private static final boolean flag;
        static {
            INSTANCE = new Singleton3(); //初次执行此行代码时 flag =false (默认值)
            flag = true;
        }
    }
    public static Singleton3 getInstance(){
        return SingletonHolder.INSTANCE;
    }
    public Object readResolve() { //防止反序列化破坏
        return getInstance();
    }
}
