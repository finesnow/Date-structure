package FileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Administrator
 * @date 2025/9/9 19:24
 * @see
 * @since JDK 17
 */
public class PropertiesTest {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties(20);
        properties.setProperty("address","neu");
        properties.setProperty("rounds","12306");
        properties.setProperty("password","12138");

        properties.store(new FileOutputStream("project.properties"),"project settings");

        Properties properties1 = new Properties();
        properties1.load(new FileInputStream("project.properties"));
        String string = properties1.getProperty("rounds");
        System.out.println(string);

    }
}
