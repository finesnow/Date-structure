package dao;

import Entity.Student;
import Entity.StudentScores;

import java.util.List;

public interface StudentDao {

    /**
     * 添加用户
     * @param student 用户
     * @return 数据库受影响的行数
     */
    int addStudent(Student student);

    /**
     * 根据id删除用户
     * @param id  用户的id
     * @return 数据库受影响的行数
     */
    int deleteStudentById(int id);

    /**
     * 根据id更新用户
     * @param student 用户
     * @return 数据库受影响的行数
     */
    int updateStudentById(Student student);

    /**
     * 根据id查询用户
     * @param id  用户的id
     * @return 用户
     */
    Student queryStudentById(int id);

    /**
     * 查询所有用户
     * @return  用户的集合
     */
    List<Student> queryAll();

    /**
     * 分页查询
     * @param page   第几页
     * @param pageSize 一页显示多少条
     * @return 分页的数据
     */
    List<Student> queryStudentByPage(int page,int pageSize);

    /**
     * 查询用户总数量
     * @return 总数量
     */
    int queryStudentCount();



    List<StudentScores> getStudentScores();
}
