package javaEE01.dao;

import javaEE01.javaBean.User;

/**
 * @author hyc
 * @date 2020/5/29
 **/
public interface UserDao {

    /**
     * 根据用户名查询数据库中的用户
     * @param username 如果返回null，说明没有这个用户
     * @return 返回用户实例
     */
    User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return 返回一个用户实例，返回null则说明用户名或者密码错误
     */
    User queryUserByName_password(String username, String password);

    /**
     * 保存用户信息
     * @param user 用户
     * @return 返回数据库影响的行数
     */
    int saveUser(User user);

    /**
     * 删除用户
     * @param username
     */
    int deleteUser(String username);

    /**
     *
     * @param user 需要修改的用户信息
     * @param username 将要把用户信息的username改为目标username
     * @param password 将要把用户信息的password改为目标password
     * @return 返回影响数据库的行数
     */
    int modify(User user,String username,String password);
}
