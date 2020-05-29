package javaEE01.dao.impl;

import javaEE01.dao.UserDao;
import javaEE01.javaBean.User;

/**
 * @author hyc
 * @date 2020/5/29
 **/
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByName_password(String username, String password) {
        String sql = "select * from user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into user values(?,?)";
        return update(sql,user.getUsername(),user.getPassword());
    }

    @Override
    public int deleteUser(String username) {
        String sql = "delete from user where username = ?";
        return update(sql,username);
    }

    @Override
    public int modify(User user,String username,String password) {
        String sql = "update user set username = ?,password = ? where username = ?";
        return update(sql,username,password,user.getUsername());
    }
}

