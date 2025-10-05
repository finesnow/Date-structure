package DesignMode.Prototype;

/**
 * @author Administrator
 * @date 2025/9/14 14:52
 * @see
 * @since JDK 17
 */

public class Coffee implements Prototype,Cloneable{
    private String Brand;
    @Override
    public Coffee Clone() {
         return  new Coffee(this.Brand);
    }

    public Coffee(String brand) {
        Brand = brand;
    }

    @Override
    public Coffee clone() throws CloneNotSupportedException {
       // return  new Coffee(this.Brand);
        return (Coffee) super.clone();
    }
}
