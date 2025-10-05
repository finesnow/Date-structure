package DesignMode.ResponChain;

/**
 * @author Administrator
 * @date 2025/9/15 19:26
 * @see
 * @since JDK 17
 */
public class DoubleHandler  extends Handler{

    public DoubleHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Number number) {
        if (number instanceof Double)
        {
            System.out.println("拿到double"+number);
        }
        else {
            nextHandler.handle(number);
        }
    }
}
