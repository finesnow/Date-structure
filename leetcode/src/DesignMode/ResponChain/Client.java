package DesignMode.ResponChain;

/**
 * @author Administrator
 * @date 2025/9/15 19:29
 * @see
 * @since JDK 17
 */
public class Client {

    public static void main(String[] args) {
       Handler handler =  new DoubleHandler(new IntegerHandler(new DefaultHandle()));
       handler.handle(Integer.valueOf("15"));
    }
}
