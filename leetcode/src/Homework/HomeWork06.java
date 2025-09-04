package Homework;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Administrator
 * @Date 2025/9/2 19:39
 * @package Homework
 * @Description:
 */
public class HomeWork06 {
        static   Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


//        System.out.println(string.matches(".+@.+\\..+"));
//        System.out.println(string.matches(".+@sina\\.com"));
//        System.out.println(new HomeWork06().isHuiWen());
        //System.out.println(new HomeWork06().removeBlank(" a bcd f gg f  f    "));

        new HomeWork06().JPG("hello.java,a.txt,x1.jpg,t1.ppt,m.jpg");
         System.out.println(new HomeWork06().SMJava("尚尚....尚..尚.⻢...⻢⻢...⻢教....教教..教.育..育育.J.A.A.V..A"));
    }
    public boolean isHuiWen(){
        String string = scanner.next();

        for (int i = 0;i<string.length()>>1;i++){
            if (string.charAt(i)!=string.charAt(string.length()-1-i)){
                return  false;
            }
        }
        return true;
    }

    public boolean Consistent(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i]!=chars2[i])
            {
                return false;
            }
        }
        return true;

    }

    public String removeBlank(String string){
        if (string==null)
            return null;

       return string.replaceAll(" ","");

    }

    public void JPG(String string){
        String[] files = string.split(",");
        for (int i = 0; i < files.length; i++) {
            if (files[i].endsWith(".jpg")){
                System.out.println(files[i]);
            }
        }
    }

    public String SMJava(String s){
        //先去除.
       s =  s.replaceAll("\\.","");
        //去除重复
       return s.replaceAll("(.)\\1+","$1");

    }

}
