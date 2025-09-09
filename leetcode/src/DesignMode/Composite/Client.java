package DesignMode.Composite;

/**
 * @author Administrator
 * @date 2025/9/6 21:49
 * @see
 * @since JDK 17
 */
public class Client {

    public static void main(String[] args) {
        File file1 = new File("论语",125);
        File file2 = new File("孙子兵法",80);
        File file3 = new File("修仙",100);
        File file4 = new File("java编程入门",200);
        File file5 = new File("ghun-48",91);
        Directory directory = new Directory("古代典籍");
        Directory directory1 = new Directory("文学类");
        Directory directory2 = new Directory("收藏夹");
        Directory directory3 = new Directory("技能类");

        directory2.add(directory1);
        directory2.add(directory3);
        directory2.add(file5);
        directory1.add(directory);
        directory1.add(file3);
        directory.add(file1);
        directory.add(file2);
        directory3.add(file4);



        AbstractEntry abstractEntry = directory2;
        abstractEntry.show();

    }
}
