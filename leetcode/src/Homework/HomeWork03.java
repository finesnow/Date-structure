package Homework;

import java.util.Arrays;
import java.util.Random;

public class HomeWork03 {

    public static void main(String[] args) {

        var homework = new HomeWork03();


//        // 求一光年是多少千米
//       System.out.println("一光年是"+homework.lightYear()+"千米");
//        // 计算周数和剩余的天数
//       homework.weekDay(46);
//        //求面积
//        System.out.println(homework.area(1.5f));
//        // 求最大值
//        int[] nums = {2,8,4,11,-1};
//        System.out.println("最大值为："+homework.maxNum(nums));
//
//        // a 与 b互换 #solution 1


//        int a = 10,b = 20;
//        System.out.println("a="+a+"  b="+b  );
//        int temp = a;
//        a = b;
//        b = temp;
//        System.out.println("a="+a+"  b="+b  );

//        // a 与 b互换 #solution 2
//        int a = 10, b = 20;
//        System.out.println("a=" + a + "  b=" + b);
//        int c = a + b;
//
//        a = c - a;
//        b = c - b;
//
//        System.out.println("a=" + a + "  b=" + b);


//        //求各个位数的和
//        int number = 365;
//        System.out.println(homework.sum(number));

        String[] array = {"天才","牛马","牛马","牛马","新手","大佬","牛马"};

        array = homework.deleteX(array,"牛马");

        System.out.println(Arrays.toString(array));

//        int[] numbs = {6,7,9,5};
//        System.out.println(Arrays.toString(homework.fourNums(numbs)));


//        String[] ids = {"202321","202422","220015","201153"};
//        homework.randomRank(ids);
//        System.out.println(Arrays.toString(ids));


    }

    public long lightYear() {
        int lightSpeed = 299792458;
        long time = 365 * 24 * 60 * 60L;
        long lightYear = lightSpeed * time;
        return lightYear / 1000;
    }

    public int[] weekDay(int day) {
        int[] weekDay = {day / 7, day % 7};
        System.out.println("共有： " + weekDay[0] + "周 " + weekDay[1] + "天");
        return weekDay;
    }

    public double area(float radius) {
        return radius * Math.PI * radius;

    }

    public int maxNum(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = max > nums[i] ? max : nums[i];
        }
        return max;
    }

    public int sum(int number) {

        if (number < 10)
            return number;
        else
            return number % 10 + sum(number / 10);

    }

    public String[] deleteX(String[] array,String x){
        int count = array.length;
        for (int i = 0; i < count; i++) {
            if (array[i].equals(x)){
                for (int j=i;j<count-1;j++){
                    array[j] = array[j+1];
                }
                i--;
                count--;
            }
        }

        String[] newArr = Arrays.copyOf(array,count);
        return  newArr;
    }


    public int[] fourNums(int[] nums){
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

    public void randomRank(String[] ids){


        Random random = new Random();
        String tmp;
        for (int i = 0; i < ids.length; i++) {
            int randomId = random.nextInt(ids.length);
            tmp = ids[i];
            ids[i] = ids[randomId];
            ids[randomId] = tmp;
//            random.nextInt(1000,10000);
        }

    }





}


