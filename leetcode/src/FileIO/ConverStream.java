package FileIO;

import java.io.*;

/**
 * @author Administrator
 * @date 2025/9/10 09:45
 * @see
 * @since JDK 17
 */
public class ConverStream {
    public static void main(String[] args) throws IOException {


        OutputStreamWriter outputStreamWriter  = new OutputStreamWriter(new FileOutputStream("..\\test.txt",true));
        outputStreamWriter.append("OutputStreamWriter23");
        outputStreamWriter.close();



        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("..\\test.txt"));

        BufferedReader bufferedReader  = new BufferedReader(inputStreamReader);
        System.out.println(bufferedReader.readLine());
        bufferedReader.close();

    }
}
