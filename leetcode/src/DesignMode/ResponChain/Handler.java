package DesignMode.ResponChain;

/**
 * @author Administrator
 * @date 2025/9/15 19:12
 * @see
 * @since JDK 17
 */
public abstract class Handler {
    protected Handler nextHandler;

    public Handler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handle(Number number);

}
