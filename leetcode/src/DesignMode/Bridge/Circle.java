package DesignMode.Bridge;

/**
 * @author Administrator
 * @Date 2025/9/4 20:42
 * @package DesignMode.Bridge
 * @Description:
 */
public class Circle extends Shape{

    public Circle(Color color) {
        super(color);
    }

    @Override
    void draw() {
        System.out.println("绘制一个圆");
        this.getColor().fill();
    }


}
