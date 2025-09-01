package Test;


import Study.HashTable;

import java.util.HashSet;
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

    public static void main(String[] args) {
//        Season autumn = Season.AUTUMN;
//        //name()输出的是常量的名字，也就是AUTUMN  这里的名字是指我们对这个常量的命名，不是这个常量对象的某个属性”秋天“
//        System.out.println(autumn.name());
//        //ordinal()输出的是该枚举对象的次序，从0开始
//        System.out.println(autumn.ordinal());
//        Season[] seasons = Season.values(); //通过枚举类的类名可以拿到所有常量
//
//        Season winter = Season.valueOf("WINTER");
//
//        System.out.println(autumn.compareTo(winter));
//        //compareTo 枚举对象的compareTo方法将返回发起者和接受者的次序差值

        //这里必须手动处理异常的原因是，process抛出的时Exception异常，它可能是运行时的也可能是编译时的异常，所以必须手动处理
//        try {
//            AnnotationProcessor.process(new AnnotationTest());
//        } catch (Exception e) {
//            throw new RuntimeException(e);

//        }



            //拷贝测试  哈希

        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        char[] chars = string.toCharArray();
        int litter=0,big=0;
        for (int i = 0; i < chars.length; i++) {
            if ('A'<=chars[i]&&chars[i]<='Z'){
                big++;
            }
            else if ('a'<=chars[i]&&chars[i]<='z')
            {
                litter++;
            }
        }
        System.out.println("大写字母有"+big+"个");
        System.out.println("小写字母有"+litter+"个");
    }


    public void testClone(){





    }



}




