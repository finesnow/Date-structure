package Stream;

import lombok.SneakyThrows;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Administrator
 * @date 2025/9/10 17:45
 * @see
 * @since JDK 17
 */
public class StreamDemo2 {

    @SneakyThrows
    public static void main(String[] args) {
//        List<Student> students = Arrays.asList(   //accessors 链式风格
//                new Student().setId(1005).setName("jordan").setScore(98.1),
//                new Student().setId(1001).setName("james").setScore(98.1),
//                new Student().setId(1003).setName("tom").setScore(59),
//                new Student().setId(1004).setName("jerry").setScore(99),
//                new Student().setId(1002).setName("kobe").setScore(98.1),
//                new Student().setId(1202).setName("jack").setScore(77.6)
//        );

        List<Student> students = Arrays.asList(     //build风格
                Student.builder().id(1005).name("jordan").score(98.1).build(),
                Student.builder().id(1006).name("james").score(93).build(),
                Student.builder().id(1001).name("tom").score(59).build(),
                Student.builder().id(1009).name("jerry").score(45.1).build(),
                Student.builder().id(1003).name("kobe").score(60.1).build(),
                Student.builder().id(1007).name("jack").score(75).build()
        );
        List<String> stringList = students.stream().filter((student) -> student.getScore() > 60)
                .sorted(Comparator.comparing(Student::getScore).reversed().thenComparing(Student::getId))
                .map(student -> student.getName())
                .toList();
        System.out.println(stringList);


    }

}
