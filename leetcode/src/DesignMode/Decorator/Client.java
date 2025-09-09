package DesignMode.Decorator;

/**
 * @author Administrator
 * @date 2025/9/8 21:59
 * @see
 * @since JDK 17
 */
public class Client {

    public static void main(String[] args) {
        TextComponent component = new BlodDecorator(new ColorDecorator(new TitleText("你从丹东来")));
        component.showText();
    }
}
