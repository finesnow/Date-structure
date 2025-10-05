package DesignMode.Prototype;

/**
 * @author Administrator
 * @Date 2025/9/3 22:47
 * @package DesignMode.Prototype
 * @Description:
 */
public class Client {

    public static void main(String[] args) {

        Coffee coffee = new Coffee("瑞星");
        try {
            coffee.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        coffee.Clone();


    }
}
