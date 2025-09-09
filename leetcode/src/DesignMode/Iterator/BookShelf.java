package DesignMode.Iterator;

import java.util.Iterator;

/**
 * @author Administrator
 * @Date 2025/9/2 16:00
 * @package DesignMode.Iterator
 * @Description:
 */
public class BookShelf implements Iterable<Book>{

    private Book[] Books;

    private int last;

    class BookShelfIterator implements java.util.Iterator<Book>{
        private int index;

        @Override
        public boolean hasNext() {
            return index < last;
        }

        @Override
        public Book next() {
            if (index>=Books.length)
                throw new IndexOutOfBoundsException();
            if (index>=last)
                throw new IllegalArgumentException();

            Book book = Books[index];
            index++;
            return book;
        }
    }


    public BookShelf(int capacity) {
        Books = new Book[capacity];
        last = 0;
    }

    private void  inti(){
        this.addBook(new Book("沧浪之水"));
        this.addBook(new Book("资本论"));
        this.addBook(new Book("人性的弱点"));
        this.addBook(new Book("商君书"));
    }
    public boolean addBook(Book book){
        if (last>=Books.length)
        {
            return false;
        }
        Books[last] = book;
        last++;
        return true;
    }
    public int getLength(){
        return last;
    }
    public Book bookAt(int i){
        return Books[i];
    }
    /**
     * @discription 作为一个集合类。通过此方法创建一个供外界使用的迭代器
     * @author dme
     * @date 2025/9/2 16:41
     * @return {@code DesignMode.Iterator.Iterator}
     **/
    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator();
    }

    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(64);
        bookShelf.inti();

        for (Book book : bookShelf) {
            System.out.println(book);
        }

    }
}
