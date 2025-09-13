package Stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author Administrator
 * @date 2025/9/10 16:31
 * @see Stream
 * @since JDK 17
 */
public class TestStreamDemo {


@Test
public void testStream(){
    //合并流
    List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
    List<Integer> list2 = Arrays.asList(5,6,7,8);
    List<Integer> list3 = Arrays.asList(1,2,7,9);
    //注意，通过Arrays.asList拿到的并不是 java.util.List，而是Arrays.ArrayList
    // 这个内部类只是继承了abstractList类，却并没有实现大多数方法，操作这个集合将导致异常

    //拿到所有集合的流对象然后合并
    Stream<Integer> stream1 = list1.stream();
    Stream<Integer> stream2 = list2.stream();
    Stream<Integer> stream3 = list3.stream();
    //合并2 3 ，再把合并结合跟1合并

    Stream<Integer> concat = Stream.concat(stream1, Stream.concat(stream2,stream3));
    //concat.forEach(System.out::println);


    //判断流中元素是否都满足某一要求
    assert concat.allMatch((integer)->{ return integer >0; });

}

}
