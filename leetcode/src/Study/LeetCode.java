package Study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/*
 * 数据结构与算法笔记 部分算法实现以及LeetCode题解
 *
 * @author 作者
 * @param 描述方法的参数。
 * @return 描述方法的返回值。
 * @throws
 * @exception  描述可能抛出的异常。
 *
 * @see 提供参考信息的链接或类/方法。
 * @since 指定自哪个版本开始存在。
 *
 * @deprecated 标记为不推荐使用的元素，并提供替代方案的信息。
 *
 * @version 提供元素的版本号。
 * 以下为文本插入型，在编写文本内容时使用
 * {@link}  插入一个提供参考信息的链接或类/方法。
 * {@code} 格式化文本为代码样式。
 * {@value} 插入静态常量的值。
 *  @apiNote api说明
 *
 */

/**
 * 数据结构与算法笔记 部分算法实现以及LeetCode题解
 * 此方法需要一个{@code int},在方法内部还需要调用{@link #betterFionacci(int, HashMap)}
 *
 * @since v1.0.0
 *
 * @version v1.0.0
 *
 * @author dme
 *
 */


@SuppressWarnings("SpellCheckingInspection")
public class LeetCode {


    public static void main(String[] args) {
        int[] array = {1,5,7,6,11,3,9,8};
        new LeetCode().shellSort(array);
        System.out.println(Arrays.toString(array));

    }



    public int middleSub(int[] numbs) {

        int numbSUM = 0, leftSum = 0;
        for (int i = 0; i < numbs.length; i++) {

            numbSUM += numbs[i];

        }

        for (int i = 0; i < numbs.length; i++) {
            if (leftSum == numbSUM - leftSum - numbs[i])
                return i;
            else
                leftSum += numbs[i];

        }

        return -1;
    }

    public int getSub(int[] nums, int target) {
        //二分法查找元素
        int left = 0, right = nums.length - 1;//
        int midIndex;
        while (left <= right) {         //left和right共同指向的元素有可能是目标
            midIndex = (left + right) >>> 2;  //防止二者之和大于int的范围 导致得到错误的下标

            if (target > nums[midIndex]) {
                left = midIndex + 1;         //之所以要+1或者-1，是为了排除已经比较过的元素
            } else if (target < nums[midIndex]) {
                right = midIndex - 1;
            } else
                return midIndex;
        }

        //left其实就是目标插入点，也就是目标插入后的索引
        return -1;
    }
    /**
     *二分查找，数组中可能存在重复的数据元素，返回最靠左的{@code int}的下标，如果没找到将返回{@code  -1}
     * @param nums 查找的目标数组
     * @param target  要查找的目标值
     * @return 找到目标时返回 {@code -1}, 否则返回一个{@code int}代表目标的下标
     * */
    public int binaryLeft(int[] nums, int target) {

        //有序数组中可能存在重复元素，此算法返回最靠左的那个数据元素
        int left = 0, right = nums.length - 1;//
        int midIndex, mostLeft = -1;
        while (left <= right) {         //left和right共同指向的元素有可能是目标
            midIndex = (left + right) >>> 2;  //防止二者之和大于int的范围 导致得到错误的下标

            if (target > nums[midIndex]) {
                left = midIndex + 1;         //之所以要+1或者-1，是为了排除已经比较过的元素
            } else if (target < nums[midIndex]) {
                right = midIndex - 1;
            } else {
                mostLeft = midIndex;
                right = midIndex - 1;
            }

        }
        return mostLeft;
        //此时left是最靠左的 大于等于目标的数据元素
        //

    }   //二分查找 最靠左

    public int recurtionBinarySearch(int[] nums, int target, int left, int right) {
        //用递归的方式实现二分法查找元素
        if (left > right) {
            return -1;
        }
        int midIndex = (left + right) >>> 1;

        //防止二者之和大于int的范围 导致得到错误的下标
        if (target == nums[midIndex]) {

            return midIndex;
            //之所以要+1或者-1，是为了排除已经比较过的元素
        } else if (target < nums[midIndex]) {
            right = midIndex - 1;

        } else
            left = midIndex + 1;

        return recurtionBinarySearch(nums, target, left, right);
        //left其实就是目标插入点，也就是目标插入后的索引

    }  //递归二分查找
    /**
     * @param nums 需要进行排序的数组
     * @param j  已经排好序的界限
    * */
    public void recurtionBubble(int[] nums, int j) {
        //用递归的方法写冒泡排序法。j指得是已经排好序的元素边界
        int tmp;
        if (j == 0) {
            return;
        }
        for (int i = 0; i < j; i++) {
            if (nums[i] > nums[i + 1]) {
                tmp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = tmp;
            }
            recurtionBubble(nums, j - 1);
        }
    }       //递归冒泡排序

    public void betterRecurtionBubble(int[] nums, int j) {
        //用递归的方法写冒泡排序法。j指得是已经排好序的元素边界,j同样需要参与比较，第一次执行j一般等于leng-1
        int tmp, x = j - 1;
        if (j == 0) {
            return;
        }
        for (int i = 0; i < j; i++) {
            if (nums[i] > nums[i + 1]) {
                tmp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = tmp;
                x = i;
                //x指的是最后一次交换前，i的位置，完成最后一次交换后，x以及x后面的元素已经有序了，
                //因此，下次比较的边界应该是x;
            }
            recurtionBubble(nums, x);
        }
    } //优化的递归冒泡

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
    }  //直接插入排序

    public void selectSort(int[] nums,int j){
        if (j==nums.length-1)
        {
            return;
        }

        int temp = 0;
        for (int i = j+1; i < nums.length; i++) {
            if (nums[i]<nums[j]){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        selectSort(nums,j+1);
    }

    public void selectSort(int[] nums){
        int temp = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            int max = i;
            for (int j = 0;j<i;j++)
            {
                if (nums[j]>nums[max]){
                    max = j;
                }
            }
            temp = nums[i];
            nums[i] = nums[max];
            nums[max] = temp;
        }
    }

    public int fionacci(int n){

        if (n==0)
            return 0;
        else if (n==1)
            return 1;

        return fionacci(n-1) + fionacci(n-2);

    }  //斐波那契数列  时间复杂度 O（1.618的n次方）

    public int betterFionacci(int n,HashMap<Integer, Integer> map){

        if (map.containsKey(n))
            return map.get(n);
        if (n==0){
            map.put(0,0);
            return 0;
        }
        else if (n==1)
        {
            map.put(1,1);
            return 1;
        }
        map.put(n,betterFionacci(n-1,map)+betterFionacci(n-2,map));
        return map.get(n);
    }  // 记忆法优化递归

    public void hanoTower(int n, LinkedList<Integer> a,LinkedList<Integer> b,LinkedList<Integer> c){

        //n是需要移动的盘子数量，a借助b，移动到c
        if (n==0){
            return;
        }
        hanoTower(n-1,a,c,b);
        c.add(a.getLast());
        hanoTower(n-1,b,a,c);
    }   //汉诺塔问题

    public int yangHuiTriangle(int i,int j){
        if (j==0||i == j){
            return 1;
        }

        return yangHuiTriangle(i-1,j-1)+yangHuiTriangle(i-1,j);

    }   //杨辉三角
/**
 * @description 堆排序算法，借助堆实现数组排序
 * @param array 需要进行排序的数组
 * @author dme
 * @date  2025/8/23 11:35
 *
 */
    public void heapSort(int[] array){
        MaxHeap maxHeap = new MaxHeap(array);
        maxHeap.heapify();
        while (maxHeap.size>1){
            maxHeap.swap(0, maxHeap.size-1);
            maxHeap.size--;
            maxHeap.down(0);
        }
        System.out.println(Arrays.toString(maxHeap.array));
    }
/**
 * @description 检查一棵二叉树是否是对称的
 * @param
 * @return
 * @author dme
 * @date  2025/8/23 15:35
 *
 */

    public boolean check(TreeNode left,TreeNode right){
        if (left==null && right==null){
            return true;
        }
        else if (left==null||right==null){
            return false;
        }

        if (left.getValue()!=right.getValue())
            return false;

        return check(left.getLeft(),right.getRight())&&check(left.getRight(),right.getLeft());
    }

    public void shellSort(int[] nums){
        for (int gap = nums.length>>1;gap>=1;gap = gap>>1)
        {
//            for (int low = 1;low<nums.length;low++)
//            {
//                int i = low-1;
//                int value = nums[low];
//                while (i>=0&&nums[i]>nums[low])
//                {
//                    nums[i+1] = nums[i];
//                    i--;
//                }
//                nums[i+1] = value;
//            }
            for (int low = gap;low<nums.length;low++)  //gap相当于是新的数组的元素间距
            {
                int i = low-gap;
                int value = nums[low];
                while (i>=0&&nums[i]>value)
                {
                    nums[i+gap] = nums[i];
                    i-=gap;
                }
                nums[i+gap] = value;
            }

        }

    }



    public void split(int[] nums,int i,int j){


        if (i==j){
            return;
        }
        int m  = (i + j) >>1;
        split(nums,i,m);

        split(nums,m+1,j);


    }
    public void merge(int[] nums,int i,int j,int x,int y,int [] temp){

    }



}
