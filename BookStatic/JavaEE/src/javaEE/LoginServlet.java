package javaEE;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hyc
 * @date 2020/5/18
 **/
public class LoginServlet extends HttpServlet {
    /**
     * 4、简述Servlet的编程过程，使用servlet完成登录验证功能。
     * servlet程序一般不直接实现servlet接口，而是继承HttpServlet类，根据需求去重写一些方法
     * 比如这里需要完成登陆验证功能，登陆信息含有密码，一般使用post方法，那么就重写doPost方法
     * 此外，在web.xml文件中配置servlet程序访问地址
     * <servlet>
     *         <servlet-name>LoginServlet</servlet-name> <!--一般是给servlet程序取一个别名，一般是类名--><br/>
     *         <servlet-class>javaEE.LoginServlet</servlet-class><!--写类的全名，包名也要带上--><br/>
     *     </servlet>
     *     <servlet-mapping><!--此处配置访问地址，与上面的配置信息要对应--><br/>
     *         <servlet-name>LoginServlet</servlet-name>
     *         <url-pattern>/loginServlet</url-pattern><!--这里对应到工程路径--><br/>
     *     </servlet-mapping>
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数，包括用户名/账号，密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //可以先判空，如果有一个为空就不用链接数量库查询了
        if (username == null || password == null) {
            return;
        }
        //此处获得请求的客户端信息后可以进行查询验证与登陆功能
        //如果验证成功则进行页面的跳转，否则跳转回登陆页面
        //链接数据库查询较为繁琐，这里假定用户名是和密码都是"admin"
        if ("admin".equals(username) && "admin".equals(password)){
            //验证成功则跳转到登陆成功页面
            req.getRequestDispatcher("/login_success.html").forward(req,resp);
        }else{
//            失败跳回登陆页面地址或者登陆失败地址
            req.getRequestDispatcher("/login_filed.html").forward(req,resp);
        }
    }
}
