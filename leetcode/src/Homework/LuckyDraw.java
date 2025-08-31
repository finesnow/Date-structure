package Homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

/**
 * @author dme
 * @Date 2025/8/22 21:29
 * @package Homework
 * @Description: “幸运抽奖”
 */
public class LuckyDraw {

    private static HashMap<String, User> users = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        User currentUser = null;
        int[] luckNumbs = generateLuckNumbs();
        int times = 3;
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("请输入个人注册信息");
                    System.out.print("用户名：");
                    String username = scanner.next();
                    System.out.print("密码：");
                    String password = scanner.next();
                    if (register(username, password)) {
                        System.out.println("注册成功,请保存好您的个人信息");
                        System.out.println(users.get(username).toString());
                    } else {
                        System.out.println("注册失败,用户名重复");
                    }
                    break;
                }
                case 2: {
                    if (currentUser != null) {
                        System.out.println("请勿重复登录！");
                    } else {
                        System.out.println("今日您还可以尝试" + times + "次");
                        if (times == 0) {
                            break;
                        }
                        System.out.print("请输入您的用户名：");
                        String username = scanner.next();
                        System.out.print("请输入您的密码：");
                        String password = scanner.next();
                        int i = login(username, password);
                        switch (i) {
                            case 0:
                                System.out.println("登录成功！");
                                currentUser = users.get(username);
                                break;
                            case 1:
                                System.out.println("密码错误！");
                                times--;
                                break;
                            case 2:
                                System.out.println("账号不存在！");
                                times--;
                                break;
                        }
                        break;
                    }
                }
                case 3: {
                    if (currentUser == null) {
                        System.out.println("请先登录！");
                    } else {
                        if (draw(currentUser.getCardNumber(), luckNumbs)) {
                            System.out.println("恭喜您成为今日的幸运用户！");
                        } else
                            System.out.println("很遗憾您不是今日的幸运用户！");
                        System.out.println("今日幸运代码：");
                        System.out.println(Arrays.toString(luckNumbs));
                    }
                    break;
                }

                default:
                    System.out.println("您的输入有误");
            }
            System.out.println("是否继续？（y/n）");
            String over = scanner.next();
            if (over.equals("n")) {
                System.out.println("系统退出，谢谢使用");
                break;
            } else if (!over.equals("y")) {
                System.out.println("您的输入有误");
            }
        }
    }

    public static void printMenu() {
        System.out.println("*****欢迎来到奖客富翁系统*****");
        System.out.println("          1.注册");
        System.out.println("          2.登录");
        System.out.println("          3.抽奖");
        System.out.println("***************************");
        System.out.println("请选择菜单:");
    }

    /**
     * @param
     * @return
     * @description
     * @author dme
     * @date 2025/8/22 22:35
     */

    public static boolean register(String username, String password) {
        if (users.containsKey(username))
            return false;
        else {
            users.put(username, new User(username, password, new Random().nextInt(1000, 10000)));
            return true;
        }

    }

    /**
     * @param
     * @return 返回一个int代表登录的结果，0代表成功，1代表密码错误，2代表用户不存在
     * @description
     * @author dme
     * @date 2025/8/22 22:33
     */

    public static int login(String username, String password) {
        if (users.containsKey(username)) {
            if (password.equals(users.get(username).getPassword()))
                return 0;
            else {
                return 1;
            }
        } else {
            return 2;
        }

    }

    public static boolean draw(int cardNumbs, int[] luckNumbs) {

        for (int i = 0; i < luckNumbs.length; i++) {
            if (luckNumbs[i] == cardNumbs)
                return true;
        }
        return false;
    }

    public static int[] generateLuckNumbs() {
        int[] luckNumbs = new int[5];
        for (int i = 0; i < luckNumbs.length; i++) {
            luckNumbs[i] = new Random().nextInt(1000, 10000);
        }
        return luckNumbs;
    }

}
