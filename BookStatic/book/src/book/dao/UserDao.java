package book.dao;

import book.pojo.User;

/**
 * @author hyc
 * @date 2020/5/17
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
}
