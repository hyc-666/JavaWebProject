package _07servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author hyc
 * @date 2020/5/4
 **/
public class ParameterForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");

        System.out.println("用户名 = " + username);
        System.out.println("密码 = " + password);
        System.out.println("兴趣爱好 = " + Arrays.asList(hobby));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //如果是post请求，在获取的时候就有可能会出现中文乱码，要先设置请求体的字符集
        req.setCharacterEncoding("UTF-8");
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobby = req.getParameterValues("hobby");

        System.out.println("用户名 = " + username);
        System.out.println("密码 = " + password);
        System.out.println("兴趣爱好 = " + Arrays.asList(hobby));
    }
}
