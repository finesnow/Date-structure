package FileIO;

import org.junit.Test;

/**
 * @author Administrator
 * @date 2025/9/10 21:46
 * @see
 * @since JDK 17
 */
public class TestStringCode {
    @Test
    public void print(){

        String string =
                """
                    file1
                        file2
                        file3
                             file4
                        file5
                    file6
                """ ;
        System.out.println(string);
    }
}
