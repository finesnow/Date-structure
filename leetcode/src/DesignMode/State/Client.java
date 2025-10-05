package DesignMode.State;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @date 2025/9/13 22:27
 * @see
 * @since JDK 17
 */
public class Client {
    public  static State state = DayState.getInstance();
    public  static int time = 8;
    public static void main(String[] args) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
              time = (time+1)%24;
              if (time>=20||time<8){
                  state = NightState.getInstance();
              }
              else {
                  state = DayState.getInstance();
              }
                System.out.println("当前时间:"+time);
                state.doorOpen();
                state.usePhone();
            }
        },0, 1000L);

    }

}
