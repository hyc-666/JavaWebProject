package book.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 抽取业务处理模块的代码
 *
 * @author hyc
 * @date 2020/8/19
 **/
public abstract class BaseServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数，区分请求的action，是注册还是登陆

        String action = req.getParameter("action");

//        //判断是注册还是登陆的请求，做出相应处理
//        if ("login".equals(action)){
//            login(req,resp);
//
//        } else if ("regist".equals(action)){
//            regist(req,resp);
//        }

        //利用反射机制来省去if-else结构，以便于以后用户模块的业务增加
        try{
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);

            method.invoke(this,req,resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
