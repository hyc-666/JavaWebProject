package _07servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hyc
 * @date 2020/5/4
 **/
public class ServletRequestApI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求的资源路径
        System.out.println("资源路径 = " + req.getRequestURI());
        //2、获取请求的统一资源定位符（绝对路径）
        System.out.println("统一资源定位符 = " + req.getRequestURL());
        //3、获取客户端ip地址
        System.out.println("客户端IP = " + req.getRemoteHost());
        //4、获取请求头
        System.out.println("请求头 = " + req.getHeader("User-Agent"));
        //5、获取请求的方式
        System.out.println("请求的方式 = " + req.getMethod());
    }
}
