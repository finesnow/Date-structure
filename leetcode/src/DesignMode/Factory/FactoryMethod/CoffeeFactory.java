package DesignMode.Factory.FactoryMethod;

/**
 * @author Administrator
 * @date 2025/9/14 14:34
 * @see
 * @since JDK 17
 */
public class CoffeeFactory extends Factory{
    @Override
    public Product newProduct() {
        System.out.println("咖啡生产完成");
        return new Coffee();
    }

    @Override
    public boolean inspection(Product p) {
        return true;
    }

    @Override
    public void packaging(Product p) {
        System.out.println("打包完成");
    }
}
