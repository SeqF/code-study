package com.study.jdbc;

import java.sql.*;

/*程序耦合
 *  耦合:程序间的依赖关系
 *      包括:
 *            类之间的依赖
 *            方法间的依赖
 *  解耦:
 *       降低程序间的依赖关系
 *  实际开发中:
 *       应该做到，编译期不依赖，运行时才依赖
 *  解耦的思路:
 *      第一步:使用反射来创建对象，而避免使用new关键字
 *      第二步，通过读取配置文件来获取要创建的对象全限定类名
 * */
public class JdbcDemo1 {
    private static String url = "jdbc:mysql://localhost:3306/world?serverTimezone=GMT&useUnicode=true&characterEncoding=utf8";
    private static String user = "root";
    private static String password = "root";

    public static void main(String[] args) throws SQLException {
        //1.注册驱动
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
//反射创建    Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection(url, user, password);
        //3.获取操作数据库的预处理对象
        String sql = "select * from city";
        PreparedStatement pstm = conn.prepareStatement(sql);
        //4.执行SQL，得到结果集合
        ResultSet rs = pstm.executeQuery();
        //5.遍历结果集
        while (rs.next()) {
            System.out.println(rs.getString("Name"));
        }
        //6.释放资源
        rs.close();
        pstm.close();
        conn.close();
    }
}
