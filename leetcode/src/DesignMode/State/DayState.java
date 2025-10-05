package DesignMode.State;

/**
 * @author Administrator
 * @date 2025/9/13 22:24
 * @see
 * @since JDK 17
 */
public class DayState implements State{

    private DayState() {
    }
    public static  State getInstance(){
        return new DayState();
    }

    @Override
    public void doorOpen() {
        System.out.println("留下记录");
    }

    @Override
    public void usePhone() {
        System.out.println("呼叫警卫中心");
    }
}
