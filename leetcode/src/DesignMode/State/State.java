package DesignMode.State;

/**
 * @author Administrator
 * @date 2025/9/13 22:21
 * @see
 * @since JDK 17
 */
public interface State {

    void doorOpen();

    default void alarm(){
        System.out.println("警报响起");
    }
    void usePhone();
}
