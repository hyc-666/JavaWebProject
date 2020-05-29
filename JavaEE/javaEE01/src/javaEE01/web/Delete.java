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
public class Delete extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        //查询用户名是否存在
        User user = userService.search(username);
        //如果存在则调用dao层删除用户
        if (user != null) {
            userService.delete(user.getUsername());
        }
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
