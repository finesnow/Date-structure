package DesignMode.Command;

/**
 * @author Administrator
 * @date 2025/9/15 17:50
 * @see
 * @since JDK 17
 */
public interface Command  extends Runnable{

    void execute();

    default void run(){
        execute();
    }
}
