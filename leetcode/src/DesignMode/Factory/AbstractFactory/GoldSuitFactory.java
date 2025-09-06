package DesignMode.Factory.AbstractFactory;

/**
 * @author Administrator
 * @Date 2025/9/4 20:09
 * @package DesignMode.Factory.AbstractFactory
 * @Description:
 */
public class GoldSuitFactory implements SuitFactory{
    @Override
    public Weapon creatWeapon() {
        return new GoldWeapon();
    }

    @Override
    public Equipment creatEquipment() {
        return new GoldEquipment();
    }
}
