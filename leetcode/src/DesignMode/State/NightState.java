package DesignMode.State;

/**
 * @author Administrator
 * @date 2025/9/13 22:26
 * @see
 * @since JDK 17
 */
public class NightState implements State{

    private NightState() {
    }
    public static  State getInstance(){
        return new NightState();
    }
    @Override
    public void doorOpen() {

        System.out.println("发送紧急通知");
        alarm();
    }

    @Override
    public void usePhone() {
        System.out.println("向警卫中心留言");
    }
}
