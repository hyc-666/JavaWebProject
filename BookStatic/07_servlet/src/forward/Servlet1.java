package forward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hyc
 * @date 2020/5/4
 **/
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求转发
        //获取请求的参数，
        String username = req.getParameter("username");
        System.out.println("在servlet1中查看请求的参数 username = " + username);
        //处理本程序的业务
        req.setAttribute("key",username);

        //之后将请求的路径跳转到另一个servlet程序或者页面
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
        //请求转发给其他地方
        requestDispatcher.forward(req,resp);
    }
}
