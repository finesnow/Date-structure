package Test;


import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Administrator
 * @Date 2025/8/27 13:07
 * @package Test
 * @Description:
 */
public class Test {

    public int testMethod(int a, int b){
        return a+b *b;
    }

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

        Instant instant = Instant.now();
        System.out.println(instant);

    }

    public int[] multiply(int[] num1, int[] num2){

        int [] result = new int[num1.length+num2.length];

        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                result[i+j] += num1[i] + num2[j];
            }
        }
        int carry = 0;

        for (int i = 0; i < result.length; i++) {
            int value = result[i];
            result[i]  = (value+carry)%10;
            carry = (value+carry)/10;

        }
        return result;
    }


    }





