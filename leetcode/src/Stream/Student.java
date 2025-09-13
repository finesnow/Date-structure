package Stream;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author Administrator
 * @date 2025/9/12 10:13
 * @see
 * @since JDK 17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Builder
public class Student {
    private int id;
    private String name;
    private double score;
}
