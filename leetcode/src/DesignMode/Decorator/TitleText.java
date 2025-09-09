package DesignMode.Decorator;

/**
 * @author Administrator
 * @date 2025/9/8 21:15
 * @see
 * @since JDK 17
 */
public class TitleText extends TextComponent{


    public TitleText(String text) {
        super(text);
    }

    @Override
    void showText() {
        System.out.println("居中加大显示"+text);
    }
}
