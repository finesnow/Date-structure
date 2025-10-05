package banker;

/**
 * @author Administrator
 * @date 2025/9/26 17:10
 * @see
 * @since JDK 17
 */
public class borrower {
    public String name;
    private AbstractSource maxSource;
    private AbstractSource currentSource;
    private AbstractSource neededSource;


    public borrower(String name ,AbstractSource maxSource, AbstractSource currentSource) {
        this.name = name;
        this.maxSource = maxSource;
        this.currentSource = currentSource;
        this.neededSource = this.maxSource.consumeSource(currentSource);
    }
    public boolean canfeed(AbstractSource abstractSource){
        return abstractSource.canFeed(neededSource);
    }
    public AbstractSource getSource(AbstractSource abstractSource){
        return  abstractSource.addSource(currentSource);
    }

}
