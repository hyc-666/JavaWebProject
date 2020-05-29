package javaEE01.service.impl;

import javaEE01.dao.UserDao;
import javaEE01.dao.impl.UserDaoImpl;
import javaEE01.javaBean.User;
import javaEE01.service.UserService;

/**
 * @author hyc
 * @date 2020/5/29
 **/
public class UserServiceImpl implements UserService {
    //与数据库交互是通过DAO层来完成的，所以服务层需要持有一个UserDao对象
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void addUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void delete(String username) {
        userDao.deleteUser(username);
    }

    @Override
    public User search(String username) {
        return userDao.queryUserByUsername(username);
    }

    @Override
    public void modify(User user,String username,String password) {
        userDao.modify(user,username,password);
    }
}
