package DesignMode.Builder;

/**
 * @author Administrator
 * @Date 2025/9/4 17:39
 * @package DesignMode.Builder
 * @Description:
 */
public class Client {

    public static void main(String[] args) {
        User user = User.builder("123456","dme").age(12).email("173763@qq.com").build();
    }
}
