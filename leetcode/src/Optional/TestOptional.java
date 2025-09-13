package Optional;

import lombok.NonNull;
import org.junit.Test;

import java.util.Optional;

/**
 * @author Administrator
 * @date 2025/9/10 22:03
 * @see
 * @since JDK 17
 */
public class TestOptional {


    public void testOptional(@NonNull  String string){
        //
        Optional<String> optionalString = Optional.of(string);

        System.out.println(true);

    }
    @Test
    public void test(){
        testOptional("null");
    }


}
