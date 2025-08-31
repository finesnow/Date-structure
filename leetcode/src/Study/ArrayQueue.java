package Study;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

/**
 * @author Administrator
 * @Date 2025/8/23 21:21
 * @package Study
 * @Description: 队列，环形数组实现
 */
public class ArrayQueue<E> implements Queue<E> {

    private int head;
    private int tail;
    private int size;
    private E[] array;

    public ArrayQueue(int capacity) {

        array = (E [])new Object[capacity];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    public boolean isFull() {
        return size==array.length;
    }


    @Override
    public boolean offer(E e) {
        if (isFull())
        {
            return false;
        }
        else {
            //tail还是指向一个没存数据的地址
            array[tail] = e;
            tail = (tail+1)%array.length;
            size++;
            return true;
        }

    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        if (isEmpty())
        {
            return null;
        }
        else
        {
            E e = array[head];
            head = (head+1)%array.length;
            return e;
        }

    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        if (isEmpty()){
            return null;
        }
        return array[head];
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

}
