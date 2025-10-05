package banker;

/**
 * @author Administrator
 * @date 2025/9/26 17:16
 * @see
 * @since JDK 17
 */
public class SourceImpl implements AbstractSource{
    protected   int  a ;
    protected int b;
    protected int c;

    public SourceImpl(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public AbstractSource addSource(AbstractSource list) {
        SourceImpl list1 = (SourceImpl) list;
        return new SourceImpl(this.a + list1.a,this.b + list1.b,this.c + list1.c);
    }

    @Override
    public AbstractSource consumeSource(AbstractSource list) {
        SourceImpl list1 = (SourceImpl) list;
        if (canFeed(list))
            return new SourceImpl(this.a - list1.a,this.b - list1.b,this.c - list1.c);
        else
            throw  new RuntimeException();
    }

    @Override
    public boolean canFeed(AbstractSource list) {
        SourceImpl list1 = (SourceImpl) list;
        return list1.a <= this.a && list1.b <= this.b && list1.c <= this.c;
    }
}
