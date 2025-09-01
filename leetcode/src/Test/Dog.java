package Test;

/**
 * @author Administrator
 * @Date 2025/9/1 16:38
 * @package Test
 * @Description:
 */
public class Dog {

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


}
