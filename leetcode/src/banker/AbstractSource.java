package banker;

/**
 * @author Administrator
 * @date 2025/9/26 17:11
 * @see
 * @since JDK 17
 */
public interface AbstractSource {

    AbstractSource consumeSource(AbstractSource list);
    boolean canFeed(AbstractSource list);
    AbstractSource addSource(AbstractSource list);
}
