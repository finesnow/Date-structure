package Test;

import java.lang.annotation.*;

/**
 * @author Administrator
 * @Date 2025/8/29 21:32
 * @package Test
 * @Description:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {
    int num1() default 0;
    int num2() default 0;
}

