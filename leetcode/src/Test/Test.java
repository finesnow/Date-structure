package Test;


import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.util.function.Consumer;

import static java.util.ArrayList.*;

/**
 * @author Administrator
 * @Date 2025/8/27 13:07
 * @package Test
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws UnsupportedEncodingException, ParseException {
//             Season autumn = Season.AUTUMN;
//             //name()输出的是常量的名字，也就是AUTUMN  这里的名字是指我们对这个常量的命名，不是这个常量对象的某个属性”秋天“
//             System.out.println(autumn.name());
//             //ordinal()输出的是该枚举对象的次序，从0开始
//             System.out.println(autumn.ordinal());
//             Season[] seasons = Season.values(); //通过枚举类的类名可以拿到所有常量
//             Season winter = Season.valueOf("WINTER");
//             System.out.println(autumn.compareTo(winter));
//             //compareTo 枚举对象的compareTo方法将返回发起者和接受者的次序差值

        //这里必须手动处理异常的原因是，process抛出的时Exception异常，它可能是运行时的也可能是编译时的异常，所以必须手动处理
//               try {
//                   AnnotationProcessor.process(new AnnotationTest());
//               } catch (Exception e) {
//                   throw new RuntimeException(e);
//               }
//                Scanner scanner = new Scanner(System.in);
//                SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyy-MM-dd");
//                String input = scanner.next();
//                Calendar calendar = Calendar.getInstance();
//                calendar.setTime(simpleDateFormat.parse(input));
//
//
//
//                if (calendar.get(Calendar.WEEK_OF_MONTH)<3){
//                    System.out.println("交易未开始");
//                }
//                else if (calendar.get(Calendar.WEEK_OF_MONTH)>3){
//                    System.out.println("交易已结束");
//                }
//                else {
//                    if (calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
//
//                        System.out.println("交易进行中");
//                    }
//                    else {
//                        System.out.println("交易未开始");
//                    }
//                }
//
//        ZoneId zoneId = ZoneId.of("Europe/London");  //获取某个时区的id 伦敦时间
//        System.out.println(zoneId);
//        ZoneOffset zoneOffset = zoneId.getRules().getOffset(Instant.now());
//        System.out.println(zoneOffset);//伦敦和UTC之间的偏移
//        //获取这个时区相较于UTC时间的偏移量，需要借助Instant才能确定 应为时间差也是随时间变化的
//
//        //本地时间转统一时间  需要结合本地时区的偏移量
//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(localDateTime);//本地时间
//
//        Instant instant = localDateTime.toInstant(ZoneOffset.systemDefault().getRules().getOffset(Instant.now()));
//        System.out.println(instant);//UTC时间
//
//        //统一时间转某个时区的时间
//        ZonedDateTime lundonTime = instant.atZone(zoneId);
//        System.out.println(lundonTime);
//
//        ZonedDateTime zonedDateTime = ZonedDateTime.now();      //本地时区的时区时间
//        LocalDateTime localDateTime1 = zonedDateTime.toLocalDateTime();  //转本地时间
//        ZonedDateTime.of(localDateTime1, ZoneId.systemDefault()); //本地时间转时区时间  结合具体时区


       List<Integer> integerList = List.of(1,5,9,7,11,5,3);
       integerList.forEach(System.out::println);

    }

    public int testMethod(int a, int b) {
        return a + b * b;
    }

    public int[] multiply(int[] num1, int[] num2) {

        int[] result = new int[num1.length + num2.length];

        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                result[i + j] += num1[i] + num2[j];
            }
        }
        int carry = 0;

        for (int i = 0; i < result.length; i++) {
            int value = result[i];
            result[i] = (value + carry) % 10;
            carry = (value + carry) / 10;

        }
        return result;
    }


}





