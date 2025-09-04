package DesignMode.Factory;

/**
 * @author Administrator
 * @Date 2025/9/3 19:32
 * @package DesignMode.Factory
 * @Description:  工厂方法模板类 提供了方法执行的整体流程 但是不提供具体的细节
 * 所有的细节交给子类来实现
 */
public abstract class Factory {

    public final Product creatProduct(){


        //生产
        Product product = newProduct();
        //质检
        if (inspection(product)){
            System.out.println("质检合格");
            //包装
            packaging(product);
            return product;
        }
        else {
            System.out.println("质检不合格");
            return null;
        }

    }

    public abstract Product newProduct();

    public abstract boolean inspection(Product p);


    public abstract void  packaging(Product p);

}
