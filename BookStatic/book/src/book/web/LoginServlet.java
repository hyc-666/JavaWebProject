package book.web;
//用户登录业务
import book.pojo.User;
import book.service.UserService;
import book.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆和注册代码全都被UserServlet取代，这个代码没有作用了
 * @author hyc
 * @date 2020/5/18
 **/

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、接收客户端的参数，
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2、检查用户名和密码的正确性
        User user = new User(null,username,password,null);
        User login = userService.login(user);
        if (login == null){
            //说明用户名或者密码错误，跳转回登陆页面
            //并且要回显服务器返回的信息，包括提示信息和已经输入的用户名
//            System.out.println("用户名或者密码错误");
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            System.out.println("登陆成功");
            System.out.println(user);
            //登陆成功则跳转到成功页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
}