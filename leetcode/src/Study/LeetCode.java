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

    public int middleSub(int[] numbs) {

        int numbSUM = 0, leftSum = 0;
        for (int numb : numbs) {

            numbSUM += numb;

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
     * 二分查找，数组中可能存在重复的数据元素，返回最靠左的{@code int}的下标，如果没找到将返回{@code  -1}
     *
     * @param nums   查找的目标数组
     * @param target 要查找的目标值
     * @return 找到目标时返回 {@code -1}, 否则返回一个{@code int}代表目标的下标
     */
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

    /**
     * @param nums
     * @param target
     * @param left
     * @param right
     * @return {@code int}
     * @discription 递归二分
     * @author dme
     * @date 2025/8/31 21:03
     **/
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
     * @param nums
     * @param j
     * @return {@code }
     * @discription 递归冒泡排序
     * @author dme
     * @date 2025/8/31 21:03
     **/
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
    }

    /**
     * @param nums
     * @param j
     * @return {@code }
     * @discription 通过记住最后一次交换的位置，优化冒泡排序
     * @author dme
     * @date 2025/8/31 21:02
     **/
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

    /**
     * @param nums
     * @param j
     * @return {@code }
     * @discription 插入排序法，多次比较、移动  一次插入
     * @author dme
     * @date 2025/8/31 21:01
     **/
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

    /**
     * @param nums
     * @return {@code }
     * @discription 选择排序法 多次比较 一次交换
     * @author dme
     * @date 2025/8/31 21:01
     **/
    public void selectSort(int[] nums) {
        int temp = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            int max = i;
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[max]) {
                    max = j;
                }
            }
            temp = nums[i];
            nums[i] = nums[max];
            nums[max] = temp;
        }
    }

    public int fionacci(int n) {

        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;

        return fionacci(n - 1) + fionacci(n - 2);

    }  //斐波那契数列  时间复杂度 O（1.618的n次方）

    public int betterFionacci(int n, HashMap<Integer, Integer> map) {

        if (map.containsKey(n))
            return map.get(n);
        if (n == 0) {
            map.put(0, 0);
            return 0;
        } else if (n == 1) {
            map.put(1, 1);
            return 1;
        }
        map.put(n, betterFionacci(n - 1, map) + betterFionacci(n - 2, map));
        return map.get(n);
    }  // 记忆法优化递归

    public void hanoTower(int n, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {

        //n是需要移动的盘子数量，a借助b，移动到c
        if (n == 0) {
            return;
        }
        hanoTower(n - 1, a, c, b);
        c.add(a.getLast());
        hanoTower(n - 1, b, a, c);
    }   //汉诺塔问题

    public int yangHuiTriangle(int i, int j) {
        if (j == 0 || i == j) {
            return 1;
        }

        return yangHuiTriangle(i - 1, j - 1) + yangHuiTriangle(i - 1, j);

    }   //杨辉三角

    /**
     * @param array 需要进行排序的数组
     * @description 堆排序算法，借助堆实现数组排序
     * @author dme
     * @date 2025/8/23 11:35
     */
    public void heapSort(int[] array) {
        MaxHeap maxHeap = new MaxHeap(array);
        maxHeap.heapify();
        while (maxHeap.size > 1) {
            maxHeap.swap(0, maxHeap.size - 1);
            maxHeap.size--;
            maxHeap.down(0);
        }
        System.out.println(Arrays.toString(maxHeap.array));
    }

    /**
     * @param
     * @return
     * @description 检查一棵二叉树是否是对称的
     * @author dme
     * @date 2025/8/23 15:35
     */

    public boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }

        if (left.getValue() != right.getValue())
            return false;

        return check(left.getLeft(), right.getRight()) && check(left.getRight(), right.getLeft());
    }

    public void shellSort(int[] nums) {
        for (int gap = nums.length >> 1; gap >= 1; gap = gap >> 1) {
            for (int low = gap; low < nums.length; low++)  //gap相当于是新的数组的元素间距
            {
                int i = low - gap;
                int value = nums[low];
                while (i >= 0 && nums[i] > value) {
                    nums[i + gap] = nums[i];
                    i -= gap;
                }
                nums[i + gap] = value;
            }
        }
    }

    /**
     * @param nums
     * @return {@code }
     * @discription 归并排序的外部入口
     * @author dme
     * @date 2025/8/31 16:39
     **/
    public void mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        split(nums, 0, nums.length - 1, temp);

    }

    /**
     * @param nums
     * @param i
     * @param j
     * @param temp
     * @return {@code }
     * @discription 实现归并算法归并函数 自上而下
     * @author dme
     * @date 2025/8/31 16:39
     **/
    private void split(int[] nums, int i, int j, int[] temp) {
        //分到数组中仅有一个元素
        if (i == j) {
            return;
        }
        if (j - i <= 16) {  //当数组已经被分到足够小，我们让它进行插入排序
            //插入排序
            limitInsertSort(nums, i, j);
            return;
        }
        //分
        int m = (i + j) >> 1;
        split(nums, i, m, temp);
        split(nums, m + 1, j, temp);

        //开始合并
        merge(nums, i, m, m + 1, j, temp);

        //读取nums的数据元素 按顺序放入temp 再把temp的数据返回nums
        System.arraycopy(temp, i, nums, i, j - i + 1);
    }

    /**
     * @param nums
     * @param i
     * @param j
     * @param x
     * @param y
     * @param temp
     * @return {@code }
     * @discription 将nums数组中的两个有序序列合并到temp数组中
     * @author dme
     * @date 2025/8/31 16:20
     **/
    public void merge(int[] nums, int i, int j, int x, int y, int[] temp) {
        //将nums中的两个有序序列合并到temp
        int k = i;
        while (i <= j && x <= y) {
            if (nums[i] < nums[x]) {
                temp[k] = nums[i];
                i++;
            } else {
                temp[k] = nums[x];
                x++;
            }
            k++;
        }
        if (i > j) {
            System.arraycopy(nums, x, temp, k, y - x + 1);
        }
        if (x > y) {
            System.arraycopy(nums, i, temp, k, j - i + 1);
        }
    }

    /**
     * @return {@code }
     * @discription 非递归方法 归并 利用宽度进行分组
     * @author dme
     * @date 2025/8/31 19:34
     **/
    public void mergeSort2(int[] nums) {
        int n = nums.length;
        int[] temp = new int[nums.length];
        for (int width = 1; width <= n / 2 + 1; width = width * 2) {

            for (int i = 0; i < n; i += width * 2) {
                int j = i + width;
                int right = Math.min(n - 1, j + width - 1);
                merge(nums, i, i + width - 1, j, right, temp);
            }
            //执行完一圈 及时覆盖nums  不然nums依然是无序的
            System.arraycopy(temp, 0, nums, 0, n);
        }
    }

    /**
     * @param nums
     * @param i
     * @param j
     * @return {@code }
     * @discription 限制了两个边界的插入排序
     * @author dme
     * @date 2025/8/31 20:58
     **/
    public void limitInsertSort(int[] nums, int i, int j) {

        for (int y = i; y < j; y++) {
            int x = y;
            int value = nums[x + 1];
            while (x >= i && value < nums[x]) {
                nums[x + 1] = nums[x];
                x--;
            }
            nums[x + 1] = value;
        }
    }

    public void quickSort(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }

    /**
     * @param nums
     * @param i
     * @param j
     * @return {@code }
     * @discription 双边快排
     * @author dme
     * @date 2025/8/31 21:10
     **/
    public void quickSort(int[] nums, int i, int j) {
        if (i >= j) {
            return;
        }
        int p = partition(nums, i, j); //p的位置已经确定，不用再考虑
        quickSort(nums, i, p - 1);
        quickSort(nums, p + 1, j);
    }
    /**
     * @discription 锁定基准元素的位置并返回
     * @author dme
     * @date 2025/8/31 22:17
     * @param nums
     * @param i
     * @param j
     * @return {@code int}
     **/
    public int partition(int[] nums, int i, int j) {
        int p = nums[i];
        int index = i; //记录一开始基准的下标
        int temp;

        while (i < j) {
            while (i < j && nums[j] > p) {
                j--;
            }

            while (i < j && nums[i] <= p) {
                i++;
            }
            //交换
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

        }
        temp = nums[i];
        nums[i] = nums[index];
        nums[index] = temp;
        return i;

    }

}
