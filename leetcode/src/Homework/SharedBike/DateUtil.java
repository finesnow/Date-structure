package Homework.SharedBike;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Administrator
 * @Date 2025/8/29 11:35
 * @package Homework.SharedBike
 * @Description:
 */
public class DateUtil {

   private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

   public static String getFormatTime(LocalDateTime dateTime){

    return dateTime.format(formatter);
   }

   public static LocalDateTime parseTime(String timeString){
       return LocalDateTime.parse(timeString, formatter);
   }


}
