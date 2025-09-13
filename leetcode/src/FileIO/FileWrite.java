package FileIO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Administrator
 * @date 2025/9/9 15:11
 * @see
 * @since JDK 17
 */
public class FileWrite {

    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            //尝试建立文件输出流  参数可以是文件名 也可以是File对象 还有一个boolean表示是追加还是覆盖 默认覆盖（false）
            fileWriter = new FileWriter("..\\test.txt",true);
            BufferedWriter bufferedWriter  =  new BufferedWriter(fileWriter);
            //写入缓冲区 每次写一个字符串或者字符数组
            bufferedWriter.write("12345678");
            //加个回车，回车的格式根据具体的操作系统而定
            bufferedWriter.newLine();
            //冲刷缓冲区（把缓冲区内容放入文件）
            bufferedWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileWriter!=null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

}
