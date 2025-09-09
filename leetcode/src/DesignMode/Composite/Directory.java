package DesignMode.Composite;

import java.util.ArrayList;

/**
 * @author Administrator
 * @date 2025/9/6 21:43
 * @see
 * @since JDK 17
 */
public class Directory extends AbstractEntry {
    private String DirectoryName;
    private ArrayList<AbstractEntry> abstractEntryArrayList;
    private int DirectorySize;

    public Directory(String directoryName) {
        DirectoryName = directoryName;
        abstractEntryArrayList = new ArrayList<>(20);
        DirectorySize = 0;
    }

    @Override
    public String getName() {
        return DirectoryName;
    }

    @Override
    public int getSize() {
        return abstractEntryArrayList.size();
    }
    @Override
    public void  add(AbstractEntry abstractEntry){
        abstractEntryArrayList.add(abstractEntry);
        System.out.println("添加了："+ abstractEntry.getName());
        this.DirectorySize += abstractEntry.getSize();
    }

    @Override
    public void show() {
        System.out.println(this.DirectoryName+"文件夹包括:");
        System.out.println("{");
        abstractEntryArrayList.forEach(AbstractEntry::show);
        System.out.println("}");
    }
}
