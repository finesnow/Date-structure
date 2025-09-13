package FileIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author Administrator
 * @date 2025/9/10 10:07
 * @see  System#in
 * @since JDK 17
 */
public class SystemIn {
    public static void main(String[] args) throws IOException {

        InputStream SystemInput =  System.in ;

        InputStreamReader inputStreamReader = new InputStreamReader(SystemInput);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println(bufferedReader.readLine());

        bufferedReader.close();
    }
}
