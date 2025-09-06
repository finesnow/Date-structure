package DesignMode.Strategy;

/**
 * @author Administrator
 * @date 2025/9/6 20:15
 * @see
 * @since JDK 17
 */
public class InsertSorter implements IntSorter{
    @Override
    public void Sort(int[] nums) {
        insertion(nums,0);
    }

    public void insertion(int[] nums, int j) {
        //直接插入排序  j依然是边界
        if (j == nums.length - 1)
            return;
        int x = nums[j + 1];
        int i = j;

        while (i >= 0 && nums[i] > x) {
            nums[i + 1] = nums[i];
            i--;
        }
        nums[i + 1] = x;
        //插入完成，新的边界为j+1
        insertion(nums, j + 1);
    }
}
