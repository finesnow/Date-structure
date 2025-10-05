package DesignMode.Command;

/**
 * @author Administrator
 * @date 2025/9/15 18:14
 * @see
 * @since JDK 17
 */
public class CleanCommand  implements Command{

    private int tableNumber;
    private Cleaner cleaner;

    public CleanCommand(int tableNumber, Cleaner cleaner) {
        this.tableNumber = tableNumber;
        this.cleaner = cleaner;
    }

    @Override
    public void execute() {
        cleaner.cleanTable(tableNumber);
    }
}
