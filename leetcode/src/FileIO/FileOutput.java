package FileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author Administrator
 * @date 2025/9/9 17:18
 * @see
 * @since JDK 17
 */
public class FileOutput {
    public static void main(String[] args) throws FileNotFoundException {
//        FileInputStream fileInputStream = null;
//        FileOutputStream fileOutputStream = null;
//        byte[] bytes = new byte[1024];
//        try {
//            fileInputStream =  new FileInputStream("尚马壁纸-01.jpg");
//            fileOutputStream = new FileOutputStream("copy.jpg",true);
//            int length = 0;
//            while ( (length = fileInputStream.read(bytes) )!= -1){
//                //读到多少写多少
//                fileOutputStream.write(bytes,0,length);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (fileInputStream != null) {
//                    fileInputStream.close();
//                }
//                if (fileOutputStream!=null){
//                    fileOutputStream.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        byte[] bytes = new byte[1024];
        FileInputStream fileInputStream = new FileInputStream("尚马壁纸-01.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("copy.txt");
        try (fileInputStream;fileOutputStream) {
            int length = 0;
            while ((length = fileInputStream.read(bytes)) != -1) {
                //读到多少写多少
                fileOutputStream.write(bytes, 0, length);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
