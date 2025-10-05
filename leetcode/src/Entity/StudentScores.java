package Entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author Administrator
 * @date 2025/9/22 22:26
 * @see
 * @since JDK 17
 */
@Data
@Accessors(chain = true)
public class StudentScores {
    private Student student;
    private Score score;

}
