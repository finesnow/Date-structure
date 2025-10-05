package DesignMode.Factory.FactoryMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import java.util.function.BiConsumer;

/**
 * @author Administrator
 * @Date 2025/9/3 19:45
 * @package DesignMode.Factory
 * @Description:
 */
public class Client {
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        //当我们需要新的产品时，只需要先创建一个工厂类 注入一个新的Factory 实例 或者也可以从配置文件中去读
        //总之无需修改任何代码
        HashMap<String,Factory> factoryHashMap = new HashMap<>();

        //配合配置文件的写法  在properties 文件中写入 产品名:对应工厂的全类名
        //系统初始化阶段 加载properties 拿到所有工厂类的类名 再利用反射 一一创建对象并且放入Hashmap中
        //获取用户输入 将输入作为key  去hashmap中拿去工厂对象
        //这样一来，添加产品时 我们只需要添加类和工厂 再把全类名写入配置文件  不需要修改任何一行代码

        Properties properties = new Properties();
        properties.load(new FileInputStream("./leetcode/src/DesignMode/Factory/FactoryMethod/factory.properties"));
        properties.forEach(new BiConsumer<Object, Object>() {
            @Override
            public void accept(Object o, Object o2) {
                Class clazz = null;
                try {
                    clazz = Class.forName((String) o2);
                    factoryHashMap.put((String) o, (Factory) clazz.newInstance());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        //模拟用户输入
        String input = new Scanner(System.in).next();
        Factory factory = factoryHashMap.get(input);
        Product product = factory.creatProduct();
        if (product != null)
            product.use();
    }
}
