package DesignMode.Composite;

/**
 * @author Administrator
 * @date 2025/9/6 21:32
 * @see
 * @since JDK 17
 */
public  abstract  class AbstractEntry {

 public  abstract String getName();

 public abstract int getSize();

 public void add(AbstractEntry abstractEntry){
     throw  new RuntimeException();
 }

 public abstract void show();



}
