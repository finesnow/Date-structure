package Test;

import java.util.Objects;

/**
 * @author Administrator
 * @Date 2025/9/1 16:38
 * @package Test
 * @Description:
 */
public class Dog implements Cloneable{

    private String dogName;
    private int age;

    public Dog(String dogName, int age) {
        this.dogName = dogName;
        this.age = age;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDogName() {
        return dogName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Dog dog)) return false;
        return getAge() == dog.getAge() && Objects.equals(getDogName(), dog.getDogName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDogName(), getAge());
    }

    @Override
    public Dog clone() throws CloneNotSupportedException {
        return (Dog) super.clone();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "dogName='" + dogName + '\'' +
                ", age=" + age +
                '}';
    }
}
