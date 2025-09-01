package Test;

import java.util.Objects;
import Test.Dog;
/**
 *@author Administrator
 *@Date  2025/9/1 14:37
 *@package Test
 *@Description:
 
 */
public class User implements Cloneable {
    /**
     * 属性的文档注释
     */
    private String username;
    private String password;
    private int age;
    Dog dog;

    public User(String username, String password, int age, Dog dog) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.dog = dog;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return age == user.age && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(dog, user.dog);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, age, dog);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {


        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {


        Dog dog = new Dog("劳狗",5);


        User user1 = new User("神棍","123",25,dog);

        System.out.println(user1.dog.getDogName());
        User user2 = (User) user1.clone();
        user2.dog.setDogName("选购");
        System.out.println(user1.dog.getDogName());



    }
}
