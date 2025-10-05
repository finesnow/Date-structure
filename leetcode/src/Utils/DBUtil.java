package Utils;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author Administrator
 * @date 2025/9/22 10:12
 * @see
 * @since JDK 17
 */
public class DBUtil {


    private DBUtil() {
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("jdbc.properties"));
            //注册驱动
            Class.forName(properties.getProperty("driver"));
            //建立连接

            connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


    public static void release(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void release(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void release(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void release(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        release(resultSet);
        release(connection, preparedStatement);
    }
    public static void release(Connection connection, PreparedStatement preparedStatement) {
        release(preparedStatement);
        release(connection);
    }


}
