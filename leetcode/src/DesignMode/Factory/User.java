package DesignMode.Factory;

/**
 * @author Administrator
 * @Date 2025/9/3 19:45
 * @package DesignMode.Factory
 * @Description:
 */
public class User {
    public static void main(String[] args) {
        Factory factory = new CocaColaFactory();
        Product product = factory.creatProduct();
        if (product!=null)
            product.use();
    }
}
