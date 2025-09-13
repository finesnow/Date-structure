package TestDemos;

import lombok.*;
import org.junit.Test;


/**
 * @author Administrator
 * @date 2025/9/10 15:04
 * @see
 * @since JDK 17
 */


@ToString(exclude = {"age"})

public class TestLombok {

    private String name;

    private String address;

    private int age;


    @Test
    public void junitTest(){
        assert false:"断言测试";
    }




}
