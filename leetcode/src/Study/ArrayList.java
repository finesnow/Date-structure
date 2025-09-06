package Study;

import java.util.*;

/**
 * @author Administrator
 * @date 2025/9/6 14:14
 * @see java.util.List
 * @since JDK 17
 */
public class ArrayList  implements List<Object> {

   private Object[] data;
   private  int size;

    @Override
    public int size() {
        return this.size;
    }

    public ArrayList() {
        data = new Object[10];
        size = 0;
    }
    public ArrayList(int length) {
        if (length < 0) throw new IllegalArgumentException();
        data = new Object[length];
        size = 0;
    }
    private ArrayList( Object[] data ,int size){
        this.data = data;
        this.size = size;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o)!=-1;
    }


    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data,size);
    }

    @Override
    public Object[] toArray(Object[] a) {
        a = Arrays.copyOf(data,size);
        return a;
    }

    @Override
    public boolean add(Object o) {
        add(size,o);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(0);
        if (index!=-1)
        {
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {

        for (Object object : c) {
            if (!contains(object))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        Object[] objects = c.toArray();
        if (objects.length==0){
            return false;
        }
        if (size+objects.length>=data.length)
            grow(size+objects.length);

        System.arraycopy(objects,0,data,size,objects.length);
        size += objects.length;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        for (Object object : c) {
            add(index,object);
            index++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (Object object : c) {
            remove(object);
        }
        return true;
    }
    @Override
    public boolean retainAll(Collection c) {
        for (Object object : this) {
            if (!c.contains(object))
                remove(object);
        }
        return true;
    }

    @Override
    public void clear() {
        data = new Object[10];
        size = 0;
    }

    @Override
    public Object get(int index) {
        rangeCheckForGet(index);
        return data[index];
    }
    private void rangeCheckForAdd(int index){
        if (index<0||index>size)
            throw new IndexOutOfBoundsException();
    }

    private void rangeCheckForGet(int index){
        if (index<0||index>=size)
            throw new IndexOutOfBoundsException();
    }


    @Override
    public Object set(int index, Object element) {
        rangeCheckForGet(index);
        data[index] = element;
        return element;
    }

    @Override
    public void add(int index, Object element) {
        rangeCheckForAdd(index);
        if (size>=data.length)
        {
            data = grow();
        }
        System.arraycopy(data,index,data,index+1,size-index);
        data[index] = element;
        size++;
    }

    private Object[] grow(){
     return grow(size+1);
    }

    private Object[] grow(int minSize){
        int newSize = Math.max(minSize, data.length + data.length>>1) ;
        return   Arrays.copyOf(data,newSize);
    }

    @Override
    public Object remove(int index) {
        rangeCheckForGet(index);
        if (index == size - 1) //如果删除的是最后一位元素 直接size-1就好了
        {
            size--;
            return data[index];
        }
        Object o = data[index];
        System.arraycopy(data,index+1,data,index,size-index-1);
        size--;
        return o;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < data.length; i++) {
            if (Objects.equals(data[i],o)){
                return i;
            }
        }
        return -1;
    }


    @Override
    public int lastIndexOf(Object o) {
        for (int i = data.length - 1; i >= 0; i--) {
            if (Objects.equals(data[i],o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator<Object> iterator() {
        return new InterIterator();
    }

    @Override
    public ListIterator<Object> listIterator() {
        return new ArrayListIterator();
    }

    @Override
    public ListIterator<Object> listIterator(int index) {
        return null;
    }

    @Override
    public String toString() {
        return  Arrays.toString(data);
    }

    @Override
    public ArrayList subList(int fromIndex, int toIndex) {
        rangeCheckForGet(fromIndex);
        rangeCheckForAdd(toIndex);
        if (fromIndex > toIndex) throw new IllegalArgumentException();
        return  new ArrayList(Arrays.copyOfRange(data,fromIndex,toIndex),toIndex-fromIndex);
    }

    private class InterIterator implements Iterator<Object>{
        int pointer = 0;
        @Override
        public boolean hasNext() {
            return pointer!=size;
        }
        @Override
        public Object next() {
            rangeCheckForGet(pointer);
            Object o = data[pointer];
            pointer++;
            return o;
        }
    }
    private class ArrayListIterator extends InterIterator implements ListIterator<Object>{

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public Object previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(Object o) {

        }

        @Override
        public void add(Object o) {

        }
    }
}
