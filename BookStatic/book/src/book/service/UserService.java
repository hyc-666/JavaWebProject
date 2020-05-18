package book.service;

import book.pojo.User;

/**
 * @author hyc
 * @date 2020/5/17
 **/
public interface UserService {

    /**
     * 用户注册
     * @param user
     */
    void registUser(User user);

    /**
     * 用户登陆业务
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 检查用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在，不可用，返回false表示此用户名可用
     */
    boolean existsUsername(String username);
}
