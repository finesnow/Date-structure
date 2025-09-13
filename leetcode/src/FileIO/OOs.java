package FileIO;

import TestDemos.User;

import java.io.*;

/**
 * @author Administrator
 * @date 2025/9/10 11:21
 * @see
 * @since JDK 17
 */
public class OOs {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("..\\test.txt",false));

        objectOutputStream.writeObject(user);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("..\\test.txt"));
        User user1 = (User)objectInputStream.readObject();

    }
}
