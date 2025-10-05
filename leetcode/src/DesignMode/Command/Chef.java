package DesignMode.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * @date 2025/9/15 18:22
 * @see
 * @since JDK 17
 */
public class Chef {

    private String name;

    public Chef(String name) {
        this.name = name;
    }
    public void cook(List<String> dishes, int tableNumber){
        dishes.forEach((string)->{
            System.out.println(this.name + "正在为"+tableNumber+"号客人制作:"+string);
        });
    }
}
