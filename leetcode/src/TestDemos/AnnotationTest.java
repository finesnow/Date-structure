package TestDemos;

/**
 * @author Administrator
 * @Date 2025/8/29 22:12
 * @package Test
 * @Description:
 */
public class AnnotationTest {

    //我们有一个求最大值的方法，添加一个注解，相当于放了两个数据在这里，初次以外注解并不发挥任何作用
    //注解真正发挥作用，使它被注解解析器发现并解析的时候，注解解析器会根据不同的注解采取不同的行动，同时结合我们给的数据
    @MyAnnotation(num1 = 5, num2 = 6)
    public int max(int a,int b){
        return Math.max(a,b);
    }
    @MyAnnotation(num1 = 7, num2 = 8)
    public int sum(int a,int b){
        return a+b;
    }
}
