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
public class SearchAndModify extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    //查询到的结果无论是否存在都是一个程序的成员变量
    private User user;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        //完成第一个表单的查询业务
        //获取请求的参数
        String username = req.getParameter("username");
        //查询是否存在
        User user = userService.search(username);
        if (user != null) {//如果不存在显示不存在，向客户端回传数据
            //将查询到的结果保存
            this.user = user;
        }
        req.getRequestDispatcher("SearchAndModify.jsp").forward(req,resp);
    }

    //这里修改操作要依赖第一个表单中的查询结果
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //完成第二个表单的修改任务
        //检查第一个请求中是否查询到结果
        if (this.user != null){//在此修改
            //将查询到的结果放入session中，由jsp页面完成查询结果回传显示
            //获取当前的待提交的参数信息
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            userService.modify(this.user,username,password);
        }
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
