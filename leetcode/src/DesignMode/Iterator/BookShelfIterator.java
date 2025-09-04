package DesignMode.Iterator;

/**
 * @author Administrator
 * @Date 2025/9/2 16:02
 * @package DesignMode.Iterator
 * @Description:
 */
public class BookShelfIterator implements java.util.Iterator<Book>{

    private final BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        index = 0;
    }
    @Override
    public boolean hasNext() {
        if (index<bookShelf.getLength()){
            return true;
        }
        return false;
    }

    @Override
    public Book next() {
        Book book = bookShelf.bookAt(index);
        index++;
        return book;
    }
}
