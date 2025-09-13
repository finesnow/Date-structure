package Thread;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author Administrator
 * @date 2025/9/13 15:25
 * @see
 * @since JDK 17
 */
public class TestTimer {
    public static void main(String[] args) {
        Timer timer = new Timer("wakeup");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("闹钟响了"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd::HH-mm-ss")));
            }
        },10000L,1000L);
    }
}
