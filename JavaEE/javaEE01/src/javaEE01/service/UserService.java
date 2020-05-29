package javaEE01.service;

import javaEE01.javaBean.User;

/**
 * @author hyc
 * @date 2020/5/29
 **/
public interface UserService {
    /**
     * 添加用户
     * @param user
     */
    void addUser(User user);

    /**
     * 删除用户
     * @param username
     */
    void delete(String username);

    /**
     * 查找用户
     * @param username
     */
    User search(String username);

    /**
     *
     * @param user 修改原用户信息
     * @param username 目标用户信息的属性
     * @param password
     */
    void modify(User user,String username,String password);
}
