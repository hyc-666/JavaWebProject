package resp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hyc
 * @date 2020/5/5
 **/
public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 请求重定向：
         * 有时候，当一个接口或者地址已经废弃不用，这个时候服务器有必要告知浏览器这个接口已经不用
         * 需要给浏览器反馈信息并且响应新的地址
         * 这个操作叫做请求重定向
//         */
//        resp.setContentType("text/html;charset=UTF-8");
//        resp.getWriter().write("response1已经失效 ！");
//        //先反馈状态码302表示此地址已经失效
//        resp.setStatus(302);
//        //之后将新的地址返回给浏览器。让浏览器重新请求新地址
//        resp.setHeader("Location","http://localhost:8080/07_servlet/resp2");
        //同样，也可以使用一行代码完成请求重定向,302是固定的
        resp.sendRedirect("http://localhost:8080/07_servlet/resp2");
    }
}
