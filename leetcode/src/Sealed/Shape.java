package Sealed;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @date 2025/9/15 16:52
 * @see
 * @since JDK 17
 */
sealed interface Shape  permits  Circle,Rectangle,Square{
    BigDecimal getAround();
    BigDecimal getArea();
}

non-sealed class Circle implements Shape{
    BigDecimal radius;

    public Circle(BigDecimal radius) {
        this.radius = radius;
    }

    @Override
    public BigDecimal getAround() {
        return radius.multiply(BigDecimal.valueOf(Math.PI)).multiply(BigDecimal.valueOf(2));
    }

    @Override
    public BigDecimal getArea() {
        return radius.multiply(BigDecimal.valueOf(Math.PI)).multiply(radius);
    }
}
non-sealed class Rectangle implements Shape{
    double length;
    double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public BigDecimal getAround() {
        return BigDecimal.valueOf(2*(length+width));
    }

    @Override
    public BigDecimal getArea() {
        return BigDecimal.valueOf(length * width);
    }
}
non-sealed class Square implements Shape{
    double width;

    public Square(double width) {
        this.width = width;
    }

    @Override
    public BigDecimal getAround() {
        return BigDecimal.valueOf(4*width);
    }

    @Override
    public BigDecimal getArea() {
        return BigDecimal.valueOf(width*width);
    }
}

class test{
    public static void main(String[] args) {
        Shape shape = new Circle(BigDecimal.valueOf(2.35));
        System.out.println(shape.getArea());
    }
}