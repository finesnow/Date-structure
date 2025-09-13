package Homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author Administrator
 * @date 2025/9/9 20:01
 * @see
 * @since JDK 17
 */
public class HomeWork16 {


    static  class student{
        private long id;
        private String name;
        private int age;
        private int score;

        public student(long id, String name, int age, int score) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.score = score;
        }

        @Override
        public String toString() {
            return "student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", score=" + score +
                    '}';
        }

        public student() {
        }


//        public int compareTo(student o) {
//            if (this.score!=o.score)
//                return o.score -  this.score ;
//            return this.age - o.age;
//        }
    }

    public static void main(String[] args) {
        ArrayList<student> students = new ArrayList<>();
        students.add(new student(1263465,"许家印",25,88));
        students.add(new student(1265324,"许家印",21,75));
        students.add(new student(1562358,"许家印",20,66));
        students.add(new student(1212453,"许家印",33,60));
        students.add(new student(1895423,"许家印",35,54));
        students.add(new student(1147536,"许家印",40,66));
        students.sort((o1,o2)->{
            if (o1.score!=o2.score)
                return o2.score -  o1.score ;
            return o1.age - o2.age;
        });
        students.forEach(System.out::println);

    }


}

