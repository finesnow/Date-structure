//package cn.javasm.dao.impl;
//
//import cn.javasm.dao.UserDao;
//import cn.javasm.entity.*;
//import cn.javasm.util.DBUtil;
//
//import java.math.BigDecimal;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDaoImpl implements UserDao {
//    @Override
//    public int addUser() {
//        // 获取数据库的连接对象
//        Connection connection = DBUtil.getConnection();
//        // 编写sql语句
//        String sql = "INSERT INTO user (username,age,password,balance) values('老王',40,'123456',9888.0)";
//        int row = 0;
//        PreparedStatement preparedStatement = null;
//        try {
//            // 获取预编译对象
//            preparedStatement = connection.prepareStatement(sql);
//            // 执行sql语句，返回数据库受影响的行数
//            row = preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            // 关闭连接
//            DBUtil.release(connection,preparedStatement);
//        }
//        return row;
//    }
//
//    @Override
//    public int addUser(User user) {
//        // 获取连接
//        Connection connection = DBUtil.getConnection();
//        // 编写sql语句
//        String sql = "INSERT INTO user (username,age,password) values(?,?,?)";
//        PreparedStatement preparedStatement = null;
//        int row = 0;
//        try {
//            // 获取预编译对象
//            preparedStatement = connection.prepareStatement(sql);
//            // 给?赋值   parameterIndex: ?的位置  从1开始
//            preparedStatement.setString(1, user.getUsername());
//            preparedStatement.setInt(2,user.getAge());
//            preparedStatement.setObject(3,user.getPassword());
//            // 执行sql语句
//            row = preparedStatement.executeUpdate();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            // 释放资源
//            DBUtil.release(connection,preparedStatement);
//        }
//        return row;
//    }
//
//
//    @Override
//    public int deleteUserById(Long id) {
//        // 获取连接
//        Connection connection = DBUtil.getConnection();
//        // 编写sql语句
//        String sql = "delete from user where id = ?";
//        PreparedStatement preparedStatement = null;
//        int row = 0;
//        try {
//            // 获取预编译对象
//            preparedStatement = connection.prepareStatement(sql);
//            // 给?赋值
//            preparedStatement.setLong(1,id);
//            // 执行sql语句
//            row = preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            // 释放资源
//            DBUtil.release(connection,preparedStatement);
//        }
//        return row;
//    }
//
//    @Override
//    public int updateUserById(User user) {
//        // 获取数据库的连接
//        Connection connection = DBUtil.getConnection();
//        // 编写sql语句
//        String sql = "update user set username = ?,age = ?,password = ?,image = ? where id = ?";
//        PreparedStatement preparedStatement = null;
//        int row = 0;
//        try {
//            // 获取预编译对象
//            preparedStatement = connection.prepareStatement(sql);
//            // 给?赋值
//            preparedStatement.setString(1, user.getUsername());
//            preparedStatement.setInt(2,user.getAge());
//            preparedStatement.setString(3,user.getPassword());
//            preparedStatement.setString(4,user.getImage());
//            preparedStatement.setLong(5,user.getId());
//
//            // 执行sql语句
//            row = preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            // 释放资源
//            DBUtil.release(connection,preparedStatement);
//        }
//        return row;
//    }
//
//    @Override
//    public User queryUserById(Long id) {
//        // 获取数据库的连接
//        Connection connection = DBUtil.getConnection();
//        // 编写sql语句
//        String sql = "select * from user where id = ?";
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        try {
//            // 获取预编译对象
//            preparedStatement = connection.prepareStatement(sql);
//            // 给?赋值
//            preparedStatement.setLong(1,id);
//            // 执行sql语句，获取结果集
//            resultSet = preparedStatement.executeQuery();
//            // 判断是否有内容
//            if (resultSet.next()){
//                User user = getUser(resultSet);
//                return user;
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            // 释放资源
//            DBUtil.release(connection,preparedStatement,resultSet);
//        }
//        return null;
//    }
//
//    /**
//     * 根据结果集获取一个用户
//     * @param resultSet  结果集
//     * @return  用户
//     * @throws SQLException
//     */
//    private static User getUser(ResultSet resultSet) throws SQLException {
//        // 获取一行记录  列的位置 从1开始
//        long uid = resultSet.getLong(1);
//        // 列名
//        String username = resultSet.getString("username");
//        int age = resultSet.getInt("age");
//        String password = resultSet.getString("password");
//        String image = resultSet.getString("image");
//        BigDecimal balance = resultSet.getBigDecimal(6);
//        LocalDateTime createTime = (LocalDateTime) resultSet.getObject(7);
//        LocalDateTime updateTime = (LocalDateTime) resultSet.getObject(8);
//        // 封装成用户对象并返回
//        User user = new User().setId(uid).setUsername(username).setPassword(password).setImage(image).setBalance(balance).setCreateTime(createTime).setUpdateTime(updateTime).setAge(age);
//        return user;
//    }
//
//    @Override
//    public List<User> queryAll() {
//        // 获取数据库的连接
//        Connection connection = DBUtil.getConnection();
//        // 编写sql语句
//        String sql = "select * from user";
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        // 创建集合
//        List<User> list = new ArrayList<>();
//        try {
//            // 获取预编译对象
//            preparedStatement = connection.prepareStatement(sql);
//            // 执行sql语句,获取结果集
//            resultSet = preparedStatement.executeQuery();
//            // 循环获取结果
//            while (resultSet.next()){
//                list.add(getUser(resultSet));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            // 释放资源
//            DBUtil.release(connection,preparedStatement,resultSet);
//        }
//        return list;
//    }
//
//    @Override
//    public List<User> queryUserByPage(int page, int pageSize) {
//        // 获取连接
//        Connection connection = DBUtil.getConnection();
//        // 编写sql语句
//        String sql = "select * from user limit ?,?";
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        List<User> list = new ArrayList<>();
//        try {
//            // 获取预编译对象
//            preparedStatement = connection.prepareStatement(sql);
//            // 给?赋值
//            preparedStatement.setInt(1,(page - 1) * pageSize);
//            preparedStatement.setInt(2,pageSize);
//            // 执行sql语句，返回结果
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                list.add(getUser(resultSet));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            // 释放资源
//            DBUtil.release(connection,preparedStatement,resultSet);
//        }
//        return list;
//    }
//
//    @Override
//    public int queryUserCount() {
//        // 获取连接
//        Connection connection = DBUtil.getConnection();
//        // 编写sql语句
//        String sql = "select count(*) from user";
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        // 定义总数量
//        int totalRow = 0;
//        try {
//            // 获取预编译对象
//            preparedStatement = connection.prepareStatement(sql);
//            // 执行sql语句，获取结果集
//            resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()){
//                totalRow = resultSet.getInt(1);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            // 释放资源
//            DBUtil.release(connection,preparedStatement,resultSet);
//        }
//        return totalRow;
//    }
//
//
//    @Override
//    public List<User> queryUserByParamAndPage(SearchParamVo searchParamVo, int page, int pageSize) {
//        // 获取连接
//        Connection connection = DBUtil.getConnection();
//        // 拼接sql语句
//        StringBuilder stringBuilder = new StringBuilder();
//        // 拼接sql语句前面固定的内容
//        stringBuilder.append("select * from user");
//
//        // 动态拼接sql
//        appendSql(searchParamVo,stringBuilder);
//
//        // 拼接sql语句后面固定的内容
//        stringBuilder.append(" limit ?,? ");
//
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        List<User> list = new ArrayList<>();
//        try {
//            // 获取预编译对象
//            preparedStatement = connection.prepareStatement(stringBuilder.toString());
//            // 给?赋值
//            int count = setParameterCount(searchParamVo,preparedStatement);
//
//            // 给limit的?赋值
//            preparedStatement.setInt(count++,(page - 1) * pageSize);
//            preparedStatement.setInt(count,pageSize);
//            // 执行sql语句获取结果集
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                list.add(getUser(resultSet));
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            // 释放资源
//            DBUtil.release(connection,preparedStatement,resultSet);
//        }
//
//        return list;
//    }
//
//    @Override
//    public int queryUserByParamCount(SearchParamVo searchParamVo) {
//        // 获取连接
//        Connection connection = DBUtil.getConnection();
//        // 拼接固定的sql内容
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("select count(*) from user ");
//        // 动态拼接sql语句
//        appendSql(searchParamVo,stringBuilder);
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        // 定义变量，记录总数量
//        int totalRow = 0;
//        try {
//            // 获取预编译对象
//            preparedStatement = connection.prepareStatement(stringBuilder.toString());
//            // 给?赋值
//            setParameterCount(searchParamVo,preparedStatement);
//            // 执行sql语句，获取结果集
//            resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()){
//                totalRow = resultSet.getInt(1);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            // 释放资源
//            DBUtil.release(connection,preparedStatement,resultSet);
//        }
//        return totalRow;
//    }
//
//    private int setParameterCount(SearchParamVo searchParamVo,PreparedStatement preparedStatement) throws SQLException {
//        // 给?赋值
//        Integer maxAge = searchParamVo.getMaxAge();
//        String endTime = searchParamVo.getEndTime();
//        String nameParam = searchParamVo.getNameParam();
//        Integer minAge = searchParamVo.getMinAge();
//        String beginTime = searchParamVo.getBeginTime();
//        // 定义变量，记录参数的位置
//        int count = 1;
//        if (nameParam != null && !nameParam.isBlank()){
//            // 有用户名
//            preparedStatement.setString(count++,"%" + nameParam + "%");
//        }
//        if (minAge != null){
//            // 有年龄
//            preparedStatement.setInt(count++,minAge);
//            preparedStatement.setInt(count++,maxAge);
//        }
//        if (beginTime != null && !beginTime.isBlank()){
//            preparedStatement.setString(count++,beginTime);
//            preparedStatement.setString(count++,endTime);
//        }
//        return count;
//    }
//
//    /**
//     * 动态拼接sql
//     */
//    private void appendSql(SearchParamVo searchParamVo,StringBuilder stringBuilder){
//        // 获取参数
//        String nameParam = searchParamVo.getNameParam();
//        Integer minAge = searchParamVo.getMinAge();
//        String beginTime = searchParamVo.getBeginTime();
//        // 判断是否已经添加where   true代表添加过
//        boolean flag = false;
//        if (nameParam != null && !nameParam.isBlank()){
//            stringBuilder.append(" WHERE username like ? AND");
//            flag = true;
//        }
//        if (minAge != null){
//            if (!flag) {
//                stringBuilder.append(" WHERE ");
//                flag = true;
//            }
//            stringBuilder.append(" age BETWEEN ? AND ? AND");
//        }
//        if (beginTime != null && !beginTime.isBlank()){
//            if (!flag){
//                stringBuilder.append(" WHERE ");
//                flag = true;
//            }
//            stringBuilder.append(" create_time BETWEEN ? AND ? AND");
//        }
//
//        if (flag){
//            // 如果有条件参数，删除掉最后一个多余的AND
//            stringBuilder.delete(stringBuilder.lastIndexOf("AND"),stringBuilder.length());
//        }
//    }
//
//    @Override
//    public List<UserRoleDeptVo> queryUserAndRoleAndDept() {
//        // 获取连接
//        Connection connection = DBUtil.getConnection();
//        // 编写sql语句
//        String sql = "select \n" +
//                "u.id,u.username,u.age,r.role_name,d.dname\n" +
//                "FROM\n" +
//                "user u,role r,dept d\n" +
//                "WHERE\n" +
//                "u.rid = r.id\n" +
//                "AND\n" +
//                "u.did = d.deptno";
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        List<UserRoleDeptVo> list = new ArrayList<>();
//        try {
//            // 获取预编译对象
//            preparedStatement = connection.prepareStatement(sql);
//            // 执行sql，获取结果集
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                long id = resultSet.getLong(1);
//                String username = resultSet.getString(2);
//                int age = resultSet.getInt("age");
//                String roleName = resultSet.getString(4);
//                String dname = resultSet.getString("dname");
//                // 封装成对象
//                UserRoleDeptVo userRoleDeptVo = new UserRoleDeptVo().setId(id).setRoleName(roleName).setAge(age).setUsername(username).setDname(dname);
//                list.add(userRoleDeptVo);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            // 释放资源
//            DBUtil.release(connection,preparedStatement,resultSet);
//        }
//        return list;
//    }
//
//    @Override
//    public List<UserRoleDept> queryUserAndRoleAndDeptAll() {
//        // 获取连接
//        Connection connection = DBUtil.getConnection();
//        // 编写sql语句
//        String sql = "select \n" +
//                " *\n" +
//                "FROM\n" +
//                "user u,role r,dept d\n" +
//                "WHERE\n" +
//                "u.rid = r.id\n" +
//                "AND\n" +
//                "u.did = d.deptno";
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        List<UserRoleDept> list = new ArrayList<>();
//        try {
//            // 获取预编译对象
//            preparedStatement = connection.prepareStatement(sql);
//            // 执行sql语句，获取结果集
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                User user = new User().setId(resultSet.getLong(1)).setUsername(resultSet.getString("username")).setAge(resultSet.getInt("age")).setBalance(resultSet.getBigDecimal("balance")).setCreateTime((LocalDateTime) resultSet.getObject("create_time"));
//                Role role = new Role().setId(resultSet.getLong(11)).setRoleName(resultSet.getString(12)).setRoleDesc(resultSet.getString(13));
//                Dept dept = new Dept().setDeptno(resultSet.getInt("deptno")).setDname(resultSet.getString("dname")).setLoc(resultSet.getString("loc"));
//                UserRoleDept userRoleDept = new UserRoleDept().setUser(user).setRole(role).setDept(dept);
//                list.add(userRoleDept);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }finally {
//            // 释放资源
//            DBUtil.release(connection,preparedStatement,resultSet);
//        }
//
//        return list;
//    }
//}
