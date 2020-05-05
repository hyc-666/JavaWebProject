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
public class ForwardC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //进行页面的跳转
        //斜杠‘/’会被服务器解析为：http://ip:port/工程路径，映射到web目录下
        System.out.println("经过forwardC程序跳转到c.html");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/a/b/c.html");
        requestDispatcher.forward(req,resp);

    }
}
