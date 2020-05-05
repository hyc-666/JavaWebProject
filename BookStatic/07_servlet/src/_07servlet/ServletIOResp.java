package _07servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hyc
 * @date 2020/5/5
 **/
public class ServletIOResp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //HttpServletResponse类
        //两个流
//        resp.getOutputStream();//字节流，常用于下载，
//        resp.getWriter();//字符流，用于回传字符串
        //两个只能同时使用一个
        System.out.println(resp.getCharacterEncoding());//查看响应的字符集 ISO-8859-1
        //默认的响应字符集是不支持中文的，需要重新设置
        resp.setCharacterEncoding("UTF-8");
        //但是此处设置还不够，只是设置了服务器的响应字符集，而大多数时候浏览器的字符集和服务器并不相同，
        //需要通过响应头来设置告知浏览器使用同样的字符集
        resp.setHeader("Content-Type","text/html;charset=UTF-8");
//        resp.setContentType("text/html;charset=UTF-8");
        // 这一行代码可以同时设置浏览器和服务器的字符集，但是一定要在获取流之前调用
        //给客户端回传字符串
        PrintWriter writer = resp.getWriter();
        writer.println("这是服务器回传的字符串信息 !");
    }
}
