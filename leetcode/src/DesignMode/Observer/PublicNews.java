package DesignMode.Observer;

/**
 * @author Administrator
 * @date 2025/9/9 10:54
 * @see
 * @since JDK 17
 */
public class PublicNews extends Observable {
    @Override
    public String newMessage() {
        return "最新时政新闻";
    }

    @Override
    public void execute() {
        notifyObservers(newMessage());
    }
}
