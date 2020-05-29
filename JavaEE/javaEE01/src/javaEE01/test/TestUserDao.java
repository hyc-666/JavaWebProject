package javaEE01.test;

import javaEE01.dao.UserDao;
import javaEE01.dao.impl.UserDaoImpl;
import javaEE01.javaBean.User;
import org.junit.Test;

/**
 * @author hyc
 * @date 2020/5/29
 **/
public class TestUserDao {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        User user = userDao.queryUserByUsername("admin123");
        if (user == null) {
            System.out.println("用户名不存在");
        } else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryUserByName_password() {
        User user = userDao.queryUserByName_password("admin4", "admin");
        if (user == null) {
            System.out.println("用户名或密码错误");
        } else {
            System.out.println(user);
        }
    }

    @Test
    public void saveUser() {
        User user = new User("hyc-666","123456");
        System.out.println(userDao.saveUser(user));
    }
    @Test
    public void delete(){
        String username = "hyc-666";
        System.out.println(userDao.deleteUser(username));
    }
    @Test
    public void modify(){
        String username = "admin";
        User user = userDao.queryUserByUsername(username);
        System.out.println(userDao.modify(user,"admin1","admin1"));
    }
}
