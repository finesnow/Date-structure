package DesignMode.Factory.AbstractFactory;

/**
 * @author Administrator
 * @Date 2025/9/4 20:10
 * @package DesignMode.Factory.AbstractFactory
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        SuitFactory factory = new GoldSuitFactory();
        Weapon weapon = factory.creatWeapon();
        Equipment equipment = factory.creatEquipment();
    }
}
