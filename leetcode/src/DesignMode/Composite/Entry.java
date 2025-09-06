package DesignMode.Composite;

/**
 * @author Administrator
 * @date 2025/9/6 21:32
 * @see
 * @since JDK 17
 */
public  abstract  class Entry {

 public  abstract String getName();

 public abstract int getSize();

 public void add(Entry entry){
     throw  new RuntimeException();
 }

 public abstract void show();



}
