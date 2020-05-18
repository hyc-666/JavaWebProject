package book.dao.impl;

import book.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author hyc
 * @date 2020/5/17
 **/
public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update方法用来执行create/insert/delete语句
     * @return 如果返回-1表示执行失败
     */
    public int update(String sql,Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    /**
     * 查询返回一个JavaBean的对象的sql语句
     * @param type 返回的对象类型
     * @param sql sql查询语句
     * @param args sql查询参数
     * @param <T> 返回的类型的泛型
     * @return 返回一个Javabean对象
     */
    public <T>T queryForOne(Class<T> type,String sql,Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 查询返回多个Javabean的sql语句
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T>List<T> queryForList(Class<T> type,String sql,Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<T>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 查询执行反不会一列的sql语句
     * @param sql sql语句
     * @param args sql语句参数
     * @return 返回查询结果的一列
     */
    public Object queryForSingleValue(String sql,Object ... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql, new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }
}
