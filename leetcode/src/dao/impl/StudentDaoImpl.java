package dao.impl;

import Entity.Score;
import Entity.SexEnum;
import Entity.Student;
import Entity.StudentScores;
import Utils.DBUtil;
import dao.StudentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Administrator
 * @date 2025/9/22 20:08
 * @see dao.StudentDao
 * @since JDK 17
 */
public class StudentDaoImpl implements StudentDao {
    Connection connection  = null;

    public StudentDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public int addStudent(Student student) {
        if (student == null) throw new NullPointerException();
        PreparedStatement statement = null;
        int lines = 0;
        try {
            String sql = "INSERT INTO student VALUES(?,?,?,?,?)";
            statement = connection.prepareStatement(sql);
            fillSQL(statement,student);
            lines = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBUtil.release(statement);
        }
        return lines;
    }
    private void fillSQL(PreparedStatement preparedStatement,Student student){
        try {
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getSexEnum().getDiscretion());
            preparedStatement.setString(4, student.getDepartment());
            preparedStatement.setString(5, student.getAddress());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int deleteStudentById(int id) {
         
        PreparedStatement statement = null;
        int lines = 0;
        try {
            String sql = "DELETE FROM student WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            lines = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DBUtil.release(statement);
        }
        return lines;
    }
    @Override
    public int updateStudentById(Student student) {
        if (student == null) throw new NullPointerException();
         
        PreparedStatement statement = null;
        int lines = 0;
        try {
            String sql = "UPDATE student SET name = ? , sex = ? , department = ?,address = ? WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getSexEnum().getDiscretion());
            statement.setString(3, student.getDepartment());
            statement.setString(4, student.getAddress());
            statement.setInt(5, student.getId());
            lines = statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBUtil.release(statement);
        }
        return lines;
    }
    @Override
    public Student queryStudentById(int id) {

          
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Student student = null;
        try {
            String sql = "SELECT * FROM student WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                student = getStudent(resultSet);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBUtil.release(statement);
            DBUtil.release(resultSet);
        }
        return student;
    }
    @Override
    public List<Student> queryAll() {
        List<Student> students = new ArrayList<>();
          
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT * FROM student";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Student student = getStudent(resultSet);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }        finally {
            DBUtil.release(statement);
            DBUtil.release(resultSet);
        }
        return students;
    }
    @Override
    public int queryStudentCount(){
        List<Student> students = new ArrayList<>();
         
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "SELECT count(*) FROM  student";
        int count = 0;
        try {
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            resultSet.next();
            count = resultSet.getInt(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }        finally {
            DBUtil.release(statement);
            DBUtil.release(resultSet);
        }

        return count;
    }
    @Override
    public List<Student> queryStudentByPage(int page, int pageSize) {
        int count = queryStudentCount();
        int maxPage = count % pageSize == 0 ?  count / pageSize : (count / pageSize +1);
        if (page+1>count)
            throw new IllegalArgumentException();

        List<Student> students = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT * FROM student LIMIT ?,?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,(page-1)*pageSize);
            statement.setInt(2,pageSize);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                students.add(getStudent(resultSet));
            }
            System.out.println("读取的总行数："  + Math.min(pageSize,count - (page-1)*pageSize ));
            System.out.println(students.size());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }        finally {
            DBUtil.release(statement);
            DBUtil.release(resultSet);
        }
        return students;
    }
    private  Student getStudent(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt("student.id")).setName(resultSet.getString("name")).setSexEnum(SexEnum.parseSex(resultSet.getString("sex")))
                .setDepartment(resultSet.getString("department")).setAddress(resultSet.getString("address"));
        return student;
    }
    @Override
    public List<StudentScores> getStudentScores() {
        List<StudentScores> studentScoresList = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            String sql = "SELECT * FROM student JOIN score ON student.id = score.stu_id";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next())
            {
                StudentScores scores = new StudentScores();
                scores.setStudent(getStudent(resultSet)).setScore(new Score().setId(
                        resultSet.getInt("score.id")).setStuId(resultSet.getInt("stu_id"))
                        .setCname(resultSet.getString("c_name")).setGrade(resultSet.getInt("grade")));
                studentScoresList.add(scores);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }        finally {
            DBUtil.release(statement);
            DBUtil.release(resultSet);
        }
        return studentScoresList;
    }
    public static void main(String[] args) {


    }
}
