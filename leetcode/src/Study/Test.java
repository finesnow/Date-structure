package Study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * @author Administrator
 * @Date 2025/8/23 19:12
 * @package Study
 * @Description: 测试类
 */

public  class Test {

    private  int a;


    private void test(){


    }


    public static void main(String[] args) {

       int []  nums = {9,7,3,5,11,12,1,8};
        new LeetCode().quickSort(nums);
       System.out.println(Arrays.toString(nums));

    }



}
