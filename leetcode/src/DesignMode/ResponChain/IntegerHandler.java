package DesignMode.ResponChain;

/**
 * @author Administrator
 * @date 2025/9/15 19:23
 * @see
 * @since JDK 17
 */
public class IntegerHandler extends Handler {

    public IntegerHandler(Handler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Number number) {
        if (number instanceof Integer)
        {
            System.out.println("拿到整形"+number);
        }
        else {
            nextHandler.handle(number);
        }
    }
}
