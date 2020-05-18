package book.service.impl;

import book.dao.UserDao;
import book.dao.impl.UserDaoImpl;
import book.pojo.User;
import book.service.UserService;

/**
 * @author hyc
 * @date 2020/5/17
 **/
public class UserServiceImpl implements UserService {
    //需要与数据库交互，而与数据库交互的任务是UserDao来完成的，
    //所以需要持有一个UserDao的实例对象
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByName_password(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        User user = userDao.queryUserByUsername(username);
        if (user == null) {//如果查询结果为控则表示用户名不存在，此用户名可用
            return false;
        } else{//不为空则表示此用户名已存在，不可用
            return true;
        }
    }
}
