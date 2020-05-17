package book.test;

import book.dao.UserDao;
import book.dao.impl.UserDaoImpl;
import book.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author hyc
 * @date 2020/5/17
 **/
public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        User user = userDao.queryUserByUsername("admin123");
        if (user== null){
            System.out.println("用户名可用");
        }else{
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryUserByName_password() {
        User user = userDao.queryUserByName_password("admin4", "admin");
        if (user== null){
            System.out.println("用户名或密码错误");
        }else{
            System.out.println(user);
        }
    }

    @Test
    public void saveUser() {
        User user = new User(null,"admin","123456","hyc666@qq.com");
        System.out.println(userDao.saveUser(user));
    }
}