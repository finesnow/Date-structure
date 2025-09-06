package DesignMode.Strategy;

/** 函数式接口 int排序器 策略模式
 * @author Administrator
 * @date 2025/9/6 19:57
 * @see
 * @since JDK 17
 */
public interface IntSorter {
    void Sort(int[] nums);
    default void print(){
        System.out.println();
    }
}
