package DesignMode.Builder;

/**
 * @author Administrator
 * @date 2025/9/14 15:42
 * @see
 * @since JDK 17
 */
public abstract  class AbstractBuilder {
    protected Bike bike = new Bike();

    public  abstract void setFrame();
    public  abstract void setSeat();

    public abstract  Bike buildBike();


}
