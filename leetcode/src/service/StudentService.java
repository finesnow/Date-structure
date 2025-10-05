package service;

import Entity.SexEnum;
import Entity.Student;
import Utils.DBUtil;
import dao.StudentDao;
import dao.impl.StudentDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Administrator
 * @date 2025/9/23 17:18
 * @see
 * @since JDK 17
 */
public class StudentService {



    public void testTransaction()  {

        Connection connection = DBUtil.getConnection();
        StudentDao studentDao = new StudentDaoImpl(connection);

        try {
            connection.setAutoCommit(false);
            studentDao.deleteStudentById(914);
            studentDao.addStudent(new Student().setId(911).setName("小古").setSexEnum(SexEnum.MALE).setDepartment("教育部").setAddress("河南郑州"));
            connection.commit();
        } catch (Exception e) {
            System.out.println("\t 异常发生");
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            DBUtil.release(connection);
        }
    }

    public static void main(String[] args) {
        Connection connection = DBUtil.getConnection();
        StudentDao studentDao = new StudentDaoImpl(connection);
        studentDao.queryStudentByPage(4,300);
    }


}
