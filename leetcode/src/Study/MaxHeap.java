package Study;

import java.util.Arrays;

/**
 * 大顶堆的实现类，基于{@link java.util.Arrays}实现，堆的大小为{@code size}
 *
 * @author dme
 * @version v1.0.0
 * @see java.util.Arrays
 * @since v1.0.0
 */
public class MaxHeap {
    int[] array;
    int size;

    public static void main(String[] args) {

        int[] array = {1, 6, 5, 3, 9, 7, 8};
        MaxHeap maxHeap = new MaxHeap(array);
        maxHeap.heapify();
        System.out.println(Arrays.toString(array));
        int count = maxHeap.size;
        //循环输出堆顶元素，得到一个降序数组，注意每次输出size都会减一
//        int[] newArray = new int[count];
//        for (int i = 0; i < count; i++) {
//            newArray[i] = maxHeap.poll();
//        }
//        System.out.println(Arrays.toString(newArray));

    }
    /**
     * @description 交换 {@code array[i]}和 {@code array[j]}的值
     * @param i 需要进行交换的其中一个下标
     * @param j 需要进行交换的其中一个下标
     * @author dme
     * @date  2025/8/23 11:48
     *
     */
    public void swap(int i,int j){
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public MaxHeap(int[] array) {
        this.array = array;
        //size初始状态下等于array的长度
        //后续如果进行操作，size可能会变化但是无法超出array.length，size始终等于堆的逻辑大小
        size = array.length;
    }

    public MaxHeap(int[] array, int size) {

        this.array = array;
        this.size = size;
    }

    public MaxHeap(int size) {
        this.array = new int[size];
        this.size = 0;
    }

    /**
     * @see #down(int)
     */
    //    构建堆
    public void heapify() {
        //1.找到最后一个非叶子结点
        //从后往前，依次执行下沉
        int n = size / 2 - 1;
        //size相当于是最后一个叶子结点，同时也是最后一个非叶子节点的孩子
        //所以 最后一个非叶子结点应该是 size/2 - 1,之所以减一，是因为size是堆的大小，是结点的数目，
        //而我们所求的是非叶子结点的索引，所以要减一。
        for (int i = n; i >= 0; i--) {
            down(i);
        }

    }
    //下沉
    public void down(int i) {
        //left是左孩子的下标，right是右孩子的下标
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        //j 代表较大的孩子下标，默认是左孩子
        int j = left;
        //如果左孩子下标越界，那必然不存在右孩子，直接返回，是递归的终止条件之一
        if (left >= size) {
            return;
        }
        //如果右孩子下标不越界，那么找出较大的孩子下标
        if (right < size) {
            j = array[left] > array[right] ? left : right;
        }
        int temp;

        //比较父结点和较大孩子的结点的值，根据比较的结果进行交换
        if (array[i] < array[j]) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            down(j);
        }
    }


    public int peek() {
        return array[0];
    }

    /**
     * 删除堆顶的元素，具体做法为，先拿到{@code array[0]}的值，将其与堆中最后一个元素{@code array[size-1]}交换
     * <p>
     * 最后再让对其执行下沉操作
     *
     * @return 返回一个代表了堆顶元素的值的  {@code int}
     * @see #down(int)
     */
    public int poll() {
        int top = array[0];
        int tmp = array[size - 1];
        //交换堆顶和堆中最后一个元素
        array[size - 1] = array[0];
        array[0] = tmp;
        size--;
        //size--后，被删除的元素依然在数组array中，但是在逻辑上已经不存在于堆中
        down(0);
        //下沉交换后的元素
        return top;
    }
    //
    public void replace(int replaced) {
        array[0] = replaced;
        down(0);
    }

    /**
     * @description 添加一个新元素进堆并维持堆的结构,先判断堆是否已满，未满则将新元素放入 {@code array[size]},{@code size++},再令其上浮{@link #up(int)}
     * @param offered 需要添加进堆的新元素
     * @return 如果堆已满则返回 {@code false},否则在上浮完成后返回 {@code true}
     * @author dme
     * @date  2025/8/23 09:48
     * @see #up(int)
     */
    public boolean offer(int offered){
        if(size ==array.length)
            return false;
        else {
            up(offered);
            size++;
            return true;
        }
    }
    /**
     * @description  上浮某个元素，对比新元素与它的父结点的值，若新元素更大则下移父节点的值，循环此过程直到根结点也被访问过
     * @param      offered 需要进行上浮的元素
     * @author dme
     * @date  2025/8/23 09:49
     *
     */

    public void up(int offered){
        //index指的是offered应该存放的位置，一开始在堆的末尾
         int index = size;
         //遍历，终结条件是index=0，再往上没东西了
         while (index>0){
             int parent = (index-1)/2;  //parent始终是index的父节点

             if (array[parent]<offered){ //如果parent较小，将父节点的值下移
                 array[index] = array[parent];
             }
             else {
                 //如果parent较小，index的正确位置已找到，结束循环即可
                 break;
             }
             //每轮循环后index上移
             index = parent;
         }
         //循环彻底结束后，index位置已确定，进行赋值
         array[index]= offered;
    }

}
