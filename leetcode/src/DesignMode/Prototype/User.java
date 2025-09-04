package DesignMode.Prototype;

/**
 * @author Administrator
 * @Date 2025/9/3 22:47
 * @package DesignMode.Prototype
 * @Description:
 */
public class User {

    public static void main(String[] args) {
        Prototype prototype = new DateElementCache();
        prototype.getClone(124312454);

    }
}
