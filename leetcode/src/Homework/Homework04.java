package Homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author dme
 * @Date 2025/8/22 19:19
 * @package Homework
 * @Description:第一阶段：数组与方法 课后作业代码
 */
public class Homework04 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //1.声明⼀个字符串的数组，空间为5个。使⽤循环接收五个学⽣的姓名。再使⽤循环倒序输出这5个学生的名字
        String[] names = new String[5];
        for (int i = names.length - 1; i >= 0; i--) {
            names[i] = scanner.nextLine();
        }
        for (int i = names.length - 1; i >= 0; i--) {
            System.out.println(names[i]);
        }

        //2.声明⼀个int型的数组，循环接收8个学⽣的成绩，计算这8个学⽣的总分、平均分、最⾼分、最低分
        int[] grades = new int[8];
        int sum = 0, highest = 0, lowest = Integer.MAX_VALUE;
        double avg = 0.0;
        for (int i = 0; i < grades.length; i++) {
            grades[i] = scanner.nextInt();
            sum += grades[i];
            highest = grades[i] > highest ? grades[i] : highest;
            lowest = grades[i] < lowest ? grades[i] : lowest;
        }
        avg = (double) sum / grades.length;
        System.out.println("8名学生的总分为：" + sum);
        System.out.println("8名学生的平均分为：" + avg);
        System.out.println("8名学生的最高分为：" + highest);
        System.out.println("8名学生的最低分为：" + lowest);

        //3.现在有如下⼀个数组： int[]  oldArr={1,3,4,5,0,0,6,6,0,5,4,7,6,7,0,5}; 要求将以上数组中的0项去掉，
        // 将不为0的值存⼊⼀个新的数组，⽣成新的数组为 int newArr[]={1,3,4,5,6,6,5,4,7,6,7,5}
        int[] oldArr = {1, 3, 4, 5, 0, 0, 6, 6, 0, 5, 4, 7, 6, 7, 0, 5};
        int[] tempArr = new int[oldArr.length];
        int j = 0;
        for (int i = 0; i < oldArr.length; i++) {
            if (oldArr[i] != 0) {
                tempArr[j] = oldArr[i];
                j++;
            }
        }
        int[] newArr = Arrays.copyOf(tempArr, j);

        System.out.println(Arrays.toString(newArr));


        //4.定义⼀个⻓度为31的整数数组，依次放⼊的2的若⼲次⽅，第⼀个放1，第⼆个放2，第三个放4，第四个放8。。。。并输出
        //int[] num= {1,2,4,8,16,32,64,128,256,512,1024,2028,4056,8112,16224,32448.....}

        int[] num = new int[31];
        num[0] = 1;
        for (int i = 1; i < num.length; i++) {
            num[i] = 2 << i - 1;
        }
        System.out.println(Arrays.toString(num));


        //5.⾃定义⼀个String数组array，现输⼊⼀个数据x，要在数组array中删除所有出现的x，
        //删除之后后⾯的元素依次向前移动。
        String[] array = {"老板", "牛马", "项目经理", "牛马", "牛马", "架构师", "实习生", "牛马"};
        System.out.println(Arrays.toString(deleteX(array,"牛马")));

        //6.现有4个数字为6、7、9、5，能组成多少个互不相同且⽆重复数字的三位数？都是多少？例如有
        //679，675，697，695，657，659.....等等
        int[] numbs = {6,7,9,5};
        System.out.println(Arrays.toString(fourNums(numbs)));

        // 7.需求：公司开发部5名开发⼈员，要进⾏项⽬进展汇报演讲，现在采取随机排名后进⾏汇报
        // 请先依次录⼊5名员⼯的⼯号，然后展示出⼀组随机的排名顺序
        String[] ids = new String[5];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = scanner.nextLine();
        }
        randomRank(ids);
        System.out.println(Arrays.toString(ids));

    }

    /**
     * @description 从数组 {@code array} 中删除所有出现的{@code x}
     * @param array  目标数组
     * @param x  需要删除的字符串
     * @return 由于涉及到了 {@code delete} 操作，因此返回一个新的数组
     * @author Administrator
     * @date 2025/8/22 19:14
     */
    public  static  String[] deleteX(String[] array, String x) {
        int count = array.length;
        for (int i = 0; i < count; i++) {
            if (array[i].equals(x)) {
                for (int j = i; j < count - 1; j++) {
                    array[j] = array[j + 1];
                }
                i--;
                count--;
            }

        }
        String[] newArr = Arrays.copyOf(array, count);
        return newArr;
    }
    /**
     * @description 使用 {@code nums}中的数字，组成尽可能多互不重复的三位数
     * @param nums 存放了所有可用数字的数组
     * @return 返回一个存放了所有可由 {@code nums}中的数字组成并且互不重复的三位数数组
     * @author dme
     * @date  2025/8/22 19:14
     *
     */

    public static  int[] fourNums(int[] nums){
        int out = 0;int[] theOuts = new int[24];
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            out += nums[i]*100;
            for (int j = 0; j < nums.length; j++) {
                if (j==i)
                    continue;
                out+=nums[j]*10;
                for (int k = 0; k < nums.length; k++) {
                    if (k==j||k==i)
                        continue;
                    out+=nums[k];
                    theOuts[count] = out;
                    out-=nums[k];
                    count++;
                }
                out-=nums[j]*10;
            }
            out-=nums[i]*100;
        }
        return theOuts;
    }
    /**
     * @description 采用随机的方式顺序打乱输入的数组
     * @author dme
     * @date  2025/8/22 19:14
     *
     */
    public  static void randomRank(String[] ids){
        Random random = new Random();
        String tmp;
        for (int i = 0; i < ids.length; i++) {
            int randomId = random.nextInt(ids.length);
            tmp = ids[i];
            ids[i] = ids[randomId];
            ids[randomId] = tmp;
        }

    }

}
