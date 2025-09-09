package Test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * @author Administrator
 * @Date 2025/8/27 13:07
 * @package Test
 * @Description:
 */
public class Test {

    public static void main(String[] args) throws IOException, ParseException {
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
        Scanner scanner = new Scanner(System.in);
        File file = new File("D:\\develop\\workspace");
        System.out.println(new Test().countJava(file,0));

    }

    public void deleteFiles(File file) {
        if (file.isFile()) {
            if (file.delete())
                System.out.println("文件" + file.getName() + "已删除");
            return;
        } else if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File file1 : files) {
                    deleteFiles(file1);
                }
            }
            if (file.delete())
                System.out.println("文件夹[" + file.getName() + "]已删除");
        }
    }

    public int countJava(File file ,int count ){
        if (file.isFile())
        {
            if (file.getName().endsWith(".java")||file.getName().endsWith(".class"))
            {
                System.out.println(file.getName());
                return count+1;
            }
        }
        File[] files = file.listFiles();
        if (files != null) {
            for (File thefile : files) {
              count =   countJava(thefile,count);
            }
        }
        return count;
    }

}





