package DesignMode.Strategy;

import java.util.Arrays;

/**
 * @author Administrator
 * @date 2025/9/6 20:07
 * @see
 * @since JDK 17
 */
public class Client {


    public static void main(String[] args) {
        int[] nums = {9, 2, 3, 5, 6, 7, 1, 8};
//           IntSorter sorter = new BubbleSorter();
        IntSorter sorter = new InsertSorter();
        new Client().SortIntArray(nums, Arrays::sort);
        System.out.println(Arrays.toString(nums));

    }

    public void SortIntArray(int[] nums, IntSorter sorter) {
        sorter.Sort(nums);
    }

}
