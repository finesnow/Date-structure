package JDBC;

import Utils.DBUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author Administrator
 * @date 2025/9/22 09:57
 * @see
 * @since JDK 17
 */
public class testMysql {
    public static void main(String[] args) {
        Connection connection = DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT name,department FROM student WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, 909);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
            }
            System.out.println(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.release(connection, statement, resultSet);
        }
    }
}
