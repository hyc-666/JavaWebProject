package servlets;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author hyc
 * @date 2020/5/3
 **/
public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println(" 1 构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println(" 2 init 初始化方法");
        /**
         * ServletConfig 类的作用
         * ServletConfig是servlet程序的配置类
         * 1、可以获取servlet程序的别名
         * 2、可以获得servlet程序的初始化信息，这个初始化信息可以取xml文件里面配置
         * 3、可以获取servletContext对象
         */
        System.out.println(" 1、HelloServlet程序的别名 = " + servletConfig.getServletName());
        System.out.println("2、HelloServlet程序的初始化参数 username = " + servletConfig.getInitParameter("username"));
        System.out.println("2、HelloServlet程序的初始化参数 url = " + servletConfig.getInitParameter("url"));
        System.out.println("3、HelloServlet程序的servletContext对象 = " + servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * service()方法是专门用来处理请求和响应数据的
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println(" 3 service方法 HelloServlet 程序被访问 ！");
        /* 构造器和初始化方法只会在servlet程序被访问是执行一次 */
        //刷新页面后，service方法可以被执行多次
        //servletRequest的类型是ServletRequest，它没有getMethod方法，只能转换为子接口才有getMethod方法
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获得请求的方式
        String method = httpServletRequest.getMethod();
//        System.out.println(method);
        if ("GET".equals(method)){
            System.out.println("GET 请求");
        }else{
            System.out.println(" POST 请求");
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println(" 4 destroy 销毁方法");
        //在web工程停止的时候会调用
    }
}
