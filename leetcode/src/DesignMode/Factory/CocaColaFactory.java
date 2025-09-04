package DesignMode.Factory;

/**
 * @author Administrator
 * @Date 2025/9/3 19:45
 * @package DesignMode.Factory
 * @Description:
 */
public class CocaColaFactory extends Factory{
    @Override
    public CocaCola newProduct() {
        System.out.println("一瓶可乐装填完毕");
        return new CocaCola(5.89);
    }

    @Override
    public boolean inspection(Product p) {
        System.out.println("质量检验中");
        if (p instanceof CocaCola cola)
        {
            return cola.getMount() >= 5.80;
        }
        return false;
    }

    @Override
    public void packaging(Product p) {
        System.out.println("泡沫箱打包完成");
    }
}
