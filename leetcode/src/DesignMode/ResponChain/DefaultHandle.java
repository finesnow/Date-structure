package DesignMode.ResponChain;

/**
 * @author Administrator
 * @date 2025/9/15 19:28
 * @see
 * @since JDK 17
 */
public class DefaultHandle extends Handler{

    public DefaultHandle() {
        super(null);
    }

    @Override
    public void handle(Number number) {
        System.out.println("默认处理" + number);
    }
}
