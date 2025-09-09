package DesignMode.Decorator;

/**
 * @author Administrator
 * @date 2025/9/8 21:58
 * @see
 * @since JDK 17
 */
public class BlodDecorator  extends Decorator{
    public BlodDecorator(TextComponent textComponent) {
        super(textComponent);
    }

    @Override
    public void DecoratorText() {
        textComponent.text += "(加粗版)";
    }
}
