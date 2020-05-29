package javaEE01.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author hyc
 * @date 2020/5/5
 **/
public class JdbcUtils {
    private static DataSource dataSource;
    //使用静态代码块创建链接并获取链接
    static {
        try{
            Properties pro = new Properties();
            InputStream inputstream = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pro.load(inputstream);
            dataSource = DruidDataSourceFactory.createDataSource(pro);
//            System.out.println(dataSource);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据库连接池的链接
     * @return 如果返回null，则说明没有获取到数据库连接对象
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void close(Connection connection){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
