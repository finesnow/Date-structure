package Homework;

/**
 * @author Administrator
 * @Date 2025/8/22 22:08
 * @package Homework
 * @Description:
 */
public class User {
    private String username;
    private String password;
    private int cardNumber;

    public User(String username, String password, int cardNumber) {
        this.username = username;
        this.password = password;
        this.cardNumber = cardNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", cardNumber=" + cardNumber +
                '}';
    }
}
