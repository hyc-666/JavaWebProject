package javaEE;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hyc
 * @date 2020/5/18
 **/
public class Counter extends HttpServlet {
    /**
     * 5、定义计数器类Counter（javabean），重新实现第2题。
     *
     * 说明，这个类仍然是一个servlet程序，做法与前面第二题的实现方法相同，
     * 只不过这次是直接将代码写在servlet程序里，
     * 这个servlet程序警告过配置就有了通用性，可以将其配置给任何一个页面来使用
     * 用以记录当前页面的访问次数，
     * 同时，写一个简单也页面完成测试，本次页面访问的次数这个数据由servlet程序经由服务器传回给客户端
     * 显示在客户端页面上
     * web.xml配置：
     * <servlet>
     *         <servlet-name>Counter</servlet-name>
     *         <servlet-class>javaEE.Counter</servlet-class>
     *     </servlet>
     *     <servlet-mapping>
     *         <servlet-name>Counter</servlet-name>
     *         <url-pattern>/counter</url-pattern>
     *     </servlet-mapping>
     */

    private static int pageCount = 0;
    private Map<String,Integer> records = new HashMap<>();
    //这里String保存的是客户端IP，Integer保存的是这个IP访问该网页的次数，该IP每访问一次该网页，value就+1

    //这里重写doGet方法，默认是此方法，只要有页面一被访问就会触发此servlet程序

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //每当有请求访问这个页面的时候，首先获得客户端IP信息
        String clientIp = req.getRemoteHost();
        //查看该IP是否已经被记录
        if (records.containsKey(clientIp)){
            //如果该IP已经访问过这个页面就更新该IP访问这个页面的次数
            int value = records.get(clientIp);
            records.put(clientIp,value + 1);
        }else{
            //如果该IP没有访问过这个网页，就使网页计数器自增，并且记录下这个IP
            pageCount++;
            records.put(clientIp,1);
        }
        //记录完成后将信息返回给客户端
        resp.setContentType(" text/html;charset=UTF-8");//设置统一字符集
        PrintWriter writer = resp.getWriter();//获得回传信息对象
        writer.write("该页面被访问的次数 = " + pageCount);
    }
}
