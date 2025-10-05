package DesignMode.Command;

/**
 * @author Administrator
 * @date 2025/9/15 18:49
 * @see
 * @since JDK 17
 */
public class Cleaner {

    private String name;

    public Cleaner(String name) {
        this.name = name;
    }
    public void cleanTable(int tableNumber){
        System.out.println(this.name + "正在清洁"  + tableNumber);
    }
}
