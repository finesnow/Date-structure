package DesignMode.Decorator;

/**
 * @author Administrator
 * @date 2025/9/8 21:16
 * @see
 * @since JDK 17
 */
public abstract class Decorator extends  TextComponent{
    TextComponent textComponent ;

    public Decorator(TextComponent textComponent) {
        super(null);
        this.textComponent = textComponent;
    }
    public abstract void DecoratorText();

    @Override
    void showText() {
        DecoratorText();
        textComponent.showText();
    }
}
