package DesignMode.Prototype;

/**
 * @author Administrator
 * @Date 2025/9/3 22:26
 * @package DesignMode.Prototype
 * @Description: 假设这个类的属性必须与数据库中的数据相绑定 ,因此新建这个对象必须在开启数据库之后
 */
public class DateElement implements Cloneable{
    @Override
    public DateElement clone()  {
        Object object = null;
        try {
            object = super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return  (DateElement)object;
    }
}
