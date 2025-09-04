package DesignMode.Iterator;

/**
 * @author Administrator
 * @Date 2025/9/2 16:00
 * @package DesignMode.Iterator
 * @Description:
 */
public class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
