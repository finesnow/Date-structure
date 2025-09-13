package FileIO;

import java.io.*;

/**
 * @author Administrator
 * @date 2025/9/9 15:21
 * @see
 * @since JDK 17
 */
public class FileRead {
    private  static  int count = 0;
    public static void main(String[] args) throws IOException {
        FileReader reader  = null;
        File file = new File("D:\\develop\\workspace");
        new FileRead().countJava(file);
        System.out.println(count+"行代码");
    }

    public void countJava(File file ) throws IOException {
        if (file.isFile())
        {
            if (file.getName().endsWith(".java"))
            {
                count+= CountJavaLines(file);
            }
        }
        File[] files = file.listFiles();
        if (files != null) {
            for (File thefile : files) {
                countJava(thefile);
            }
        }
    }
    public int CountJavaLines(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        int i = 0;
        while (bufferedReader.readLine()!=null)
        {
            i++;
        }
        bufferedReader.close();
        return i;
    }

}
