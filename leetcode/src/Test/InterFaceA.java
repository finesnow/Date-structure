package Test;

import java.util.function.Function;

/**
 * @author Administrator
 * @Date 2025/8/28 14:26
 * @package Test
 * @Description:
 */
public interface InterFaceA {

    int COUNT = 0;


    public  abstract int Abstract(int a,int b); //实现类需要实现的抽象方法，在接口中不能有方法体

    default void defaultMethod(){  //默认的实现方法，可以有方法体，实现类可以重写，也可以不重写
        support();
        defaultMethod2();
        System.out.println("default");
    }

     default void defaultMethod2(){  //默认的实现方法，可以有方法体，实现类可以重写，也可以不重写
        support();
        System.out.println("default2");
    }

    private void support() {      //私有的方法，用来辅助默认的实现方法
        System.out.println("support");
    }

    public static void publicStatic(){ //静态方法
        privateStatic();
        System.out.println("Static");
    }

    private static void privateStatic(){ //私有静态，用来辅助公开的静态方法（代码复用）
        System.out.println("Static");
    }

    public static void main(String[] args) {

//        InterFaceA faceA = new InterFaceA() {
//            @Override
//            public void Abstract(String s) {
//                System.out.println("接口的匿名实现类");
//            }
//        };
        Abstract abs = new Abstract() {
            @Override
            public void doIt() {
                System.out.println("抽象类的匿名实现类");
            }
        };
//        Test test = new Test(){
//            @Override
//            public void test(){
//                super.test();
//                System.out.println("普通类的匿名子类，重写其方法");
//            }
//
//        };

        InterFaceA interFaceA = Math::max;
        interFaceA = Math::min;
        System.out.println(interFaceA.toString());
        interFaceA = Integer::sum;
        Test test = new Test();


        Function<String, Integer> str = String::length;

        //方法只有一行代码，也可以省略大括号：
        //interFaceA = (str)-> System.out.println(str);
        //参数只有一个，小括号也可以省略
        //interFaceA = str-> System.out.println(str);
        //本质还是一个对象,相当于拿到了一个接口的实现类对象，而且可以访问私有方法






    }

}
