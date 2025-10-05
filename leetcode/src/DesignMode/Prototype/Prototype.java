package DesignMode.Prototype;

/**
 * @author Administrator
 * @Date 2025/9/3 22:24
 * @package DesignMode.Prototype
 * @Description:
 */
public interface Prototype { //这个接口在java中已经有了 CloneAble  直接继承CloneAble即可

    Object Clone();
}
