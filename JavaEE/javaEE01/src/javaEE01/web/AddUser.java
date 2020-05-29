package javaEE01.web;

import javaEE01.javaBean.User;
import javaEE01.service.UserService;
import javaEE01.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hyc
 * @date 2020/5/29
 **/
public class AddUser extends HttpServlet{
    //
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(username,password);
        //调用dao层保存用户
        userService.addUser(user);
        //跳转回这个页面
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
