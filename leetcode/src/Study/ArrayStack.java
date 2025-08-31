package Study;

/**
 * @author Administrator
 * @Date 2025/8/24 10:04
 * @package Study
 * @Description: 栈 数组实现
 *
 */
public class ArrayStack<E> {

    private int top;
    private E[] array;


    public ArrayStack(int capacity) {
        array = (E[]) new Object[capacity];
        this.top = 0;
    }

    public boolean isEmpty(){

        return top==0;
    }
    public boolean isFull(){

        return top==array.length;
    }


    public boolean push(E e){
        if (isFull())
        return  false;
        else
            array[top] = e;
            top++;
            return true;
    }

    public E pop(){
        if (isEmpty())
        {
            return null;
        }
        else
        {
            E e = array[top-1];
            top--;
            return e;
        }
    }

    public E peek(){
        return null;
    }
}
