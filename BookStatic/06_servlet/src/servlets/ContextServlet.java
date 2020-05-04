package servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hyc
 * @date 2020/5/3
 **/

/**
 * ServletContext类的四个作用
 * 1、获取web.xml当中配置的上下文参数context-param
 * 2、获取当前的工程路径，格式：/工程路径
 * 3、获取工程部署后在服务器磁盘上的绝对路径
 * 4、像map一样存取数据
 */
public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletConfig().getServletContext();
        String username = context.getInitParameter("username");
        System.out.println("contextServlet程序的上下文参数username = " + username);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、获取web.xml当中配置的上下文参数context-param
        ServletContext context = getServletConfig().getServletContext();
        String username = context.getInitParameter("username");
        System.out.println("contextServlet程序的上下文参数username = " + username);
        //2、获取当前的工程路径，格式：/工程路径
        System.out.println("工程路径 = " + context.getRealPath("/"));//获得工程绝对路径
        // 斜杠‘/’在服务器解析为：http://ip:port/工程名
    }
}
