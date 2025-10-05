package Entity;
import lombok.Data;
import lombok.experimental.Accessors;
/**
 * @author Administrator
 * @date 2025/9/22 17:37
 * @see
 * @since JDK 17
 */
@Data
@Accessors(chain = true)
public class Student {
    private int id;
    private String name;
    private SexEnum sexEnum;
    private String department;
    private String address;
}
