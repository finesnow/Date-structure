package DesignMode.Composite;

/**
 * @author Administrator
 * @date 2025/9/6 21:41
 * @see
 * @since JDK 17
 */
public class File extends AbstractEntry {
    private String fileName;
    private int fileSize;

    public File(String fileName, int fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    @Override
    public String getName() {
        return fileName;
    }

    @Override
    public int getSize() {
        return fileSize;
    }

    @Override
    public void show() {
        System.out.println(fileName+".txt 文件大小:" + fileSize);
    }

}
