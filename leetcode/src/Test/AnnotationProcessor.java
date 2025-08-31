package Test;

import java.lang.reflect.Method;

/**
 * @author Administrator
 * @Date 2025/8/29 22:16
 * @package Test
 * @Description: 自定义的注解解析器，模拟注解被获取并且 被解析的过程
 */
public class AnnotationProcessor {


    public static void process(Object obj) throws Exception {
        for (Method method : obj.getClass().getDeclaredMethods()) {  //获取所有方法
            if (method.isAnnotationPresent(MyAnnotation.class)) {  //发现被注解标记的方法,方法可以发现注解，返回注解对象
                MyAnnotation anno = method.getAnnotation(MyAnnotation.class);  //拿到注解对象
                System.out.println("方法名：" + method.getName());
//                System.out.println(anno.num1()); //获取到当初我们放在方法上的信息
//                System.out.println(anno.num2()); //获取到当初我们放在方法上的信息
                System.out.println(method.invoke(obj, anno.num1(), anno.num2())); // 调用带注解的方法
            }
        }
    }
}