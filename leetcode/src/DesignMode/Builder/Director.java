package DesignMode.Builder;

/**
 * @author Administrator
 * @date 2025/9/14 15:46
 * @see
 * @since JDK 17
 */
public class Director {

    AbstractBuilder abstractBuilder;

    public Bike construct(){
        abstractBuilder.setSeat();
        abstractBuilder.setFrame();
        return abstractBuilder.buildBike();
    }

    public Director(AbstractBuilder abstractBuilder) {
        this.abstractBuilder = abstractBuilder;
    }
}
