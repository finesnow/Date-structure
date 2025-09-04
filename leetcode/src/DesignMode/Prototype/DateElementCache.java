package DesignMode.Prototype;

import java.util.HashMap;

/**
 * @author Administrator
 * @Date 2025/9/3 22:27
 * @package DesignMode.Prototype
 * @Description:
 */
public class DateElementCache implements Prototype{
    HashMap<Integer,DateElement> hashMap = new HashMap<>();
    private void  inti(){
    }
    @Override
    public DateElement getClone(Integer id) {
        if (hashMap.containsKey(id))
        {
            return hashMap.get(id).clone();
        }
        else {
            return null;
        }
    }
    private boolean readElement(Integer id){
        try{
            System.out.println("开启数据库并查询");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        DateElement dateElement = new DateElement();
        if (dateElement!=null)
        {
            hashMap.put(id,dateElement);
            return true;
        }
        return false;
    }
}
