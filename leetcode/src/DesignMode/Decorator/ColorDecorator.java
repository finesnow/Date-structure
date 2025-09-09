package DesignMode.Decorator;

/**
 * @author Administrator
 * @date 2025/9/8 21:35
 * @see
 * @since JDK 17
 */
public class ColorDecorator extends Decorator{

    public ColorDecorator(TextComponent textComponent) {
        super(textComponent);
    }

    @Override
    public void DecoratorText() {
        textComponent.text += "(彩色版)";
    }

}
