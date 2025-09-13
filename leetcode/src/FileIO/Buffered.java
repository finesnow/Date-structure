package FileIO;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * @author Administrator
 * @date 2025/9/9 21:43
 * @see
 * @since JDK 17
 */
public class Buffered {

    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("..\\test.txt");
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);) {
        } catch (Exception exception) {

        }
    }
}
