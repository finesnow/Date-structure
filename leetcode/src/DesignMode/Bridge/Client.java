package DesignMode.Bridge;

/**
 * @author Administrator
 * @Date 2025/9/4 20:45
 * @package DesignMode.Bridge
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        Shape shape = new Circle(new Bule());
        shape.draw();

        shape = new Rectangle(new Red());
        shape.draw();
    }
}
