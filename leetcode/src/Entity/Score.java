package Entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author Administrator
 * @date 2025/9/22 22:22
 * @see
 * @since JDK 17
 */
@Data
@Accessors(chain = true)
public class Score {

    private int id;
    private int stuId;
    private String cname;
    private int grade;

}
