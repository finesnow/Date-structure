package Study;

/**
 * @author Administrator
 * @Date 2025/8/23 15:42
 * @package Study
 * @Description:动态数组实现,动态数组是支持并简化增加、插入、移除、遍历、扩容的灵活数组
 */

public class DynamicArray {

    private int size = 0; //逻辑上数组已经存储的元素个数
    private int capacity = 8;// 数组最大容量
    private int[] array;//依托于数组实现

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.size = 0;
    }

    public DynamicArray() {
        this.array = new int[capacity];
        this.size = 0;
    }

    public DynamicArray(int[] array) {
        this.array = array;
        this.capacity = array.length;
        this.size = array.length;
    }

    /**
     * @param
     * @return
     * @description 向动态数组中添加一个数
     * @author dme
     * @date 2025/8/23 15:52
     */
    public void addElement(int element) {
        //数组已满
        if (check()) {
            extend();
        }
        insertElement(element, size);
    }

    /**
     * @param element
     * @param index
     * @return void
     * @author dme
     * @date 2025/8/23 16:01
     * @description 向动态数组的指定位置插入一个指定的值
     */

    public void insertElement(int element, int index) {

        if (index >= 0 && index <= size) {
            if (index != size) //如果插入的位置不是数组末尾，执行arraycopy
                System.arraycopy(array, index, array, index + 1, size - index);

            array[index] = element;
            size++;
        } else {
            //抛出异常
            System.out.println("我是异常");
        }

    }

    /**
     * @param index 要移除的元素的下标
     * @return 一个存放了被移除元素值的 {@code int}
     * @discription 从动态数组中移除指定下标的值
     * @author dme
     * @date 2025/8/23 17:52
     **/
    public int removeElement(int index) {

        int removed = array[index];
        if (index < size - 1)
            System.arraycopy(array, index + 1, array, index, size - index - 1);

        size--;
        return removed;

    }
    /**
     * @discription 扩容
     * @author dme
     * @date 2025/8/23 19:52
     * @return {@code }
     **/
    public void extend(){
        capacity = capacity + capacity>>1;
        int[] newArray = new int[capacity];
        System.arraycopy(array,0,newArray,0,size);
        array = newArray;
    }
    /**
     * @discription 检查动态数组是否已满
     * @author dme
     * @date 2025/8/23 19:59
     * @return {@code boolean}，数组已满则返回{@code true}，否则返回{@code false}
     **/
    public boolean check(){

        if (size>=capacity){
            return true;
        }
        return false;
    }

}
