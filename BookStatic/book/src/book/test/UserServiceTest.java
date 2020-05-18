package book.test;

import book.pojo.User;
import book.service.UserService;
import book.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author hyc
 * @date 2020/5/17
 **/
public class UserServiceTest {

    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"username1","password1","username1@qq.com"));
        userService.registUser(new User(null,"username2","password2","username2@qq.com"));
    }

    @Test
    public void login() {
        User user = userService.login(new User(null, "admin", "admin", null));
        if (user == null) {
            System.out.println("登陆失败");
        }else{
            System.out.println(user);
        }
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("admin3")){
            System.out.println("用户名已存在");
        }else {
            System.out.println("用户名可用");
        }
    }
}