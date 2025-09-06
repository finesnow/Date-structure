package DesignMode.Bridge;

/**
 * @author Administrator
 * @Date 2025/9/4 20:39
 * @package DesignMode.Bridge
 * @Description:
 */
public abstract  class Shape {

   private Color color;



    public Color getColor() {
        return color;
    }

    public Shape(Color color) {
        this.color = color;
    }

    public void addColor(){
        color.fill();
    }

    abstract void  draw();
}
