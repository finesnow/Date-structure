package DesignMode.Builder;

/**
 * @author Administrator
 * @date 2025/9/14 15:43
 * @see
 * @since JDK 17
 */
public class OfoBikeBuilder extends AbstractBuilder{
    @Override
    public void setFrame() {
        this.bike.setFrame("ofo frame");
    }

    @Override
    public Bike buildBike() {
        return this.bike;
    }

    @Override
    public void setSeat() {
        this.bike.setSeat("ofo seat");
    }
}
