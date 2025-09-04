package DesignMode.Prototype;

/**
 * @author Administrator
 * @Date 2025/9/3 22:24
 * @package DesignMode.Prototype
 * @Description:
 */
public interface Prototype extends Cloneable{
    Object getClone(Integer id);
}
