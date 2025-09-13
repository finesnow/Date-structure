package FileIO;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author Administrator
 * @date 2025/9/10 10:15
 * @see
 * @since JDK 17
 */
public class IO {
    public static void main(String[] args) throws IOException {
        //文件 基本字节输入流     字符和编码息息相关 但是和字节无关
        FileInputStream fileInputStream = new FileInputStream("..\\test.txt");
        //文件 基本字节输出流   文件名  追加或者覆盖
        FileOutputStream fileOutputStream = new FileOutputStream("..\\test.txt",true);

        //文件 基本字符输入流   文件名 编码格式
        FileReader fileReader = new FileReader("文件名", Charset.defaultCharset());
        //文件 基本字符输出流   文件名  编码格式  追加或者覆盖
        FileWriter fileWriter = new FileWriter("..\\test.txt", Charset.defaultCharset(), true);

        //文件 缓冲字节输入流  可以指定缓冲区大小 默认8192  除了有缓存 效率更高  在使用上和基本字节流基本一致
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        //文件 缓冲字节输出流  可以指定缓冲区大小 默认8192  除了有缓存 效率更高  在使用上和基本字节流基本一致
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);


        //文件  缓冲字符输入流 可以指定缓冲区大小 默认8192 新功能readline 一次读一整行 读到换行符停止 且不包含换行符
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.readLine();
        //文件  缓冲字符输入流 可以指定缓冲区大小 默认8192 新功能newLine 输入一个换行符
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.newLine();

        //转换流 将字节流转换为字符基本流    可以再装饰为缓冲字符流
        OutputStreamWriter outputStreamWriter  = new OutputStreamWriter(new FileOutputStream("..\\test.txt",true));
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("..\\test.txt"));

    }
}
