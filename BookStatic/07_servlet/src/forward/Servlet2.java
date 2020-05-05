package forward;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hyc
 * @date 2020/5/4
 **/
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查看参数
        String username = req.getParameter("username");
        //不过我感觉上这两个查看参数的操作好像并没有什么关联性，
        System.out.println("在servlet2中查看参数 username = " + username);
        //查看servlet1的操作
        Object key = req.getAttribute("key");
        System.out.println("查看servlet1中的操作 = " + key);
        System.out.println("处理自己的业务");
    }
}
