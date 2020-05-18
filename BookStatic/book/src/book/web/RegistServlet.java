package book.web;

import book.pojo.User;
import book.service.UserService;
import book.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hyc
 * @date 2020/5/17
 **/
public class RegistServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //2、检查验证码是否正确,目前验证码固定为“abcde”
        if ("abcde".equalsIgnoreCase(code)){//验证码需要忽略大小写
            //3、检查用户名是否可用,需要链接数据库查询
            if(userService.existsUsername(username)){//返回true表示用户名已存在
                //跳转回注册页面
                System.out.println("用户名["+ username +"]已存在");
                req.getRequestDispatcher("pages/user/regist.html").forward(req,resp);
            }else{//返回false表示用户名可用
                User user = new User(null,username,password,email);
                userService.registUser(user);//将用户信息保存到数据库
                //跳转到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.html").forward(req,resp);
            }
        }else{//如果验证码不正确就跳回注册页面
            System.out.println("验证码["+ code +"]不正确");
            req.getRequestDispatcher("/pages/user/regist.html").forward(req,resp);
        }
    }
}
