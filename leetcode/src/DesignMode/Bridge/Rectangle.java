package DesignMode.Bridge;

/**
 * @author Administrator
 * @Date 2025/9/4 20:46
 * @package DesignMode.Bridge
 * @Description:
 */
public class Rectangle extends Shape{
    public Rectangle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.println("画一个矩形");
        this.getColor().fill();
    }
}
