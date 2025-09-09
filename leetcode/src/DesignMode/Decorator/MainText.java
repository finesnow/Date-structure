package DesignMode.Decorator;

/**
 * @author Administrator
 * @date 2025/9/8 21:14
 * @see
 * @since JDK 17
 */
public class MainText extends TextComponent{

    public MainText(String text) {
        super(text);
    }

    @Override
    void showText() {
        System.out.println("正文格式展示"+ text);
    }
}
