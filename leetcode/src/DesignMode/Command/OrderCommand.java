package DesignMode.Command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @date 2025/9/15 18:05
 * @see
 * @since JDK 17
 */
public class OrderCommand implements Command {
    private List<String> dishes;

    private int tableNumber;

    private Chef chef;

    public OrderCommand(List<String> dishes, int tableNumber, Chef chef) {
        this.dishes = dishes;
        this.tableNumber = tableNumber;
        this.chef = chef;
    }

    @Override
    public void execute() {
        chef.cook(dishes,tableNumber);
    }

}
