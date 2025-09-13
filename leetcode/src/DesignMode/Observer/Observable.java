package DesignMode.Observer;

import java.util.LinkedList;

/**
 * @author Administrator
 * @date 2025/9/9 14:57
 * @see
 * @since JDK 17
 */
public abstract class Observable {

  private final LinkedList<Observer> observers =  new LinkedList<>() ;

    public boolean attach(Observer observer){
      return   observers.add(observer);
    }

    public void notifyObservers(String message){
      for (Observer observer : observers) {
        observer.update(message);
      }
    }

  public abstract  String newMessage();

  public abstract  void execute();
}
