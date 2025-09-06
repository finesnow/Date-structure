package DesignMode.Strategy;

/**
 * @author Administrator
 * @date 2025/9/6 20:01
 * @see
 * @since JDK 17
 */
public class BubbleSorter implements IntSorter{
    @Override
    public void Sort(int[] nums) {
        BubbleSort(nums,nums.length-1);
    }

    private void BubbleSort(int[] nums,int j) {
        if (j==0)
            return;
        for (int i = 0; i < j; i++) {
            if (nums[i+1]<nums[i])
                swap(nums,i,i+1);
        }
        BubbleSort(nums,j-1);
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
