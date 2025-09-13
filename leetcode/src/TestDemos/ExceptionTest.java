package TestDemos;

import java.util.Scanner;

/**
 * @author Administrator
 * @Date 2025/8/30 17:44
 * @package Test
 * @Description:
 */
public class ExceptionTest {

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        //如果用户的输入有误，那么break语句会被跳过，循环将不会结束
//        while (true){
//            String input = scanner.next();
//            try {
//               int x = Integer.parseInt(input);
//               break;
//            }
//            catch (Exception exception){
//                System.out.println( "\""+input + "\"不是一个整数");
//            }
//        }



    }
    private static void getInput() throws RuntimeException{

        int age = scanner.nextInt();
        if (age<18||age>100)
        {
            throw new MyException("年龄不合理");
        }

    }


}
