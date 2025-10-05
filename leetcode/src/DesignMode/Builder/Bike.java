package DesignMode.Builder;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Administrator
 * @date 2025/9/14 15:38
 * @see
 * @since JDK 17
 */
@Setter
@Getter

public class Bike {
    //模拟复杂的构建过程
    private String frame;
    private String seat;

}
