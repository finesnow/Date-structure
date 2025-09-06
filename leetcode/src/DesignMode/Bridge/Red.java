package DesignMode.Bridge;

/**
 * @author Administrator
 * @Date 2025/9/4 20:45
 * @package DesignMode.Bridge
 * @Description:
 */
public class Red implements Color{
    @Override
    public void fill() {
        System.out.println("红色填充");
    }
}
