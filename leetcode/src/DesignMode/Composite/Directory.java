package DesignMode.Composite;

import java.util.ArrayList;

/**
 * @author Administrator
 * @date 2025/9/6 21:43
 * @see
 * @since JDK 17
 */
public class Directory extends Entry{
    private String DirectoryName;
    private ArrayList<Entry> entryArrayList;
    private int DirectorySize;

    public Directory(String directoryName) {
        DirectoryName = directoryName;
        entryArrayList = new ArrayList<>(20);
        DirectorySize = 0;
    }

    @Override
    public String getName() {
        return DirectoryName;
    }

    @Override
    public int getSize() {
        return entryArrayList.size();
    }
    @Override
    public void  add(Entry entry){
        entryArrayList.add(entry);
        System.out.println("添加了："+entry.getName());
        this.DirectorySize +=entry.getSize();
    }

    @Override
    public void show() {
        System.out.println(this.DirectoryName+"文件夹包括:");
        System.out.println("{");
        entryArrayList.forEach(Entry::show);
        System.out.println("}");
    }
}
