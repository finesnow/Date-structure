package DesignMode.Builder;

/**
 * @author Administrator
 * @Date 2025/9/4 17:39
 * @package DesignMode.Builder
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
    //需求变更时 修改配置文档来注入不同的 AbstractBuilder 实现类

    Director director = new Director(new OfoBikeBuilder());

    Bike bike = director.construct();

    User user = User.builder("12306","铁路安全").age(12).email("17653").build();
        System.out.println(user);
    }
}
