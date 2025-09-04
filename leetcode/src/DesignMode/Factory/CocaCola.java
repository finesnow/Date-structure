package DesignMode.Factory;

/**
 * @author Administrator
 * @Date 2025/9/3 19:41
 * @package DesignMode.Factory
 * @Description:
 */
public class CocaCola extends Product{

    private double mount;

    public CocaCola(double mount) {
        this.mount = mount;
    }

    public double getMount() {
        return mount;
    }

    @Override
    public void use() {
        System.out.println("喝可乐");
    }
}
