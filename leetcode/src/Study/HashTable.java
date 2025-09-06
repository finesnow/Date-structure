package Study;

/**
 * @author Administrator
 * @Date 2025/8/30 10:22
 * @package Study
 * @Description: 为数组中的数据设置一个编号，建立起编号与索引之间的关系，将来就可以通过编号快速查询数据
 * f(关哈希码) = 索引
 * 这也解释了为什么每个对象都有hashcode方法，而且这个hashcode的计算与对象的地址有关，就是为了避免重复
 * 哈希函数要做的 就是建立起hashcode与线性表下标之间的映射关系
 */
public class HashTable {

    static class Entry{
        int hashcode;
        int key;
        String value;
        Entry next;

        public Entry(int hashcode, int key, String value) {
            this.hashcode = hashcode;  //哈希码是用来计算下标的
            this.key = key; // 关键字是用来区分的
            this.value = value;
        }
    }

    /*
    *  求模运算可替换为位运算
    *
    *   hash%数组长度 = hash & (数组长度-1)
    *
    * */

    Entry[] table = new Entry[16];
    int size = 0;

    String get(int hashcode,int key){
        int index = hashcode & (table.length-1);//根据哈希码求下标
        Entry start = table[index];
        if (start==null)
            return null;
        else
        {
            while (start!=null)
            {
                if (start.key ==key)
                {
                    return start.value;
                }
                start = start.next;
            }
        }
        return null;
    }

    void put(int hashcode,int key,String value){
        int index = hashcode & (table.length-1);
        Entry start = table[index];
        if (start==null)
        {
            table[index] = new Entry(hashcode,key,value);
            size++;
        }
        else {
            Entry pre = null;
            while (start!=null){

                if (start.key == key){
                    start.value = value;
                    return;
                }
                pre = start;
                start = start.next;
            }
            pre.next = new Entry(hashcode,key,value);
            size++;
        }
    }

    String remove(int hashcode,int key){
        int index = hashcode & (table.length-1);
        Entry start = table[index];
        if (start==null)
        {
            return null;
        }
        else {
            Entry pre = null;
            while (start!=null){
                if (start.key == key){ //找到了
                    if (pre!=null)
                    {
                        pre.next = start.next;
                    }
                    else {
                        table[index] = start.next;
                    }
                    size--;
                    return start.value;
                }
                pre = start;
                start = start.next;
            }
            //没找到
            return null;
        }

    }


}
