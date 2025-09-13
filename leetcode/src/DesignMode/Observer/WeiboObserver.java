package DesignMode.Observer;

/**
 * @author Administrator
 * @date 2025/9/9 22:17
 * @see
 * @since JDK 17
 */
public class WeiboObserver implements Observer{
    @Override
    public void update(String message) {
        System.out.println("微博页面更新"+message);
    }
}
