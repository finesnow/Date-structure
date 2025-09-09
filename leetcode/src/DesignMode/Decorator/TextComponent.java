package DesignMode.Decorator;

/** 装饰器模式
 * @author Administrator
 * @date 2025/9/8 21:11
 * @see
 * @since JDK 17
 */
public abstract class TextComponent {
    protected String text;

    public TextComponent(String text) {
        this.text = text;
    }

    abstract  void showText();

}
