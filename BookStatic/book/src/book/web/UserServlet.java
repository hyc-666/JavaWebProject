package book.web;

import book.pojo.User;
import book.service.UserService;
import book.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 合并注册的servlet和登陆的servlet
 * 一个servlet就可以同时处理登陆和注册的业务
 * @author hyc
 * @date 2020/8/19
 **/
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();

    /**
     * 单独抽出方法来处理登陆的业务
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("处理登陆的业务");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //2、检查用户名和密码的正确性
        User user = new User(null,username,password,null);
        User login = userService.login(user);
        if (login == null){
            //说明用户名或者密码错误，跳转回登陆页面
            //并且要回显服务器返回的信息，包括提示信息和已经输入的用户名
//            System.out.println("用户名或者密码错误");
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);

            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            System.out.println("登陆成功");
//            System.out.println(user);
            //登陆成功则跳转到成功页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    /**
     * 单独抽出方法来处理注册的业务
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("处理注册的业务");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //2、检查验证码是否正确,目前验证码固定为“abcde”
        if ("abcde".equalsIgnoreCase(code)){//验证码需要忽略大小写

            //3、检查用户名是否可用,需要链接数据库查询
            if(userService.existsUsername(username)){//返回true表示用户名已存在
                //跳转回注册页面
                System.out.println("用户名["+ username +"]已存在");
                //需要在客户端回显错误信息，要先把需要回显的信息保存在request域中
                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                //验证码根据要求回显
                req.getRequestDispatcher("pages/user/regist.jsp").forward(req,resp);
            }else{//返回false表示用户名可用
                User user = new User(null,username,password,email);
                userService.registUser(user);//将用户信息保存到数据库
                //跳转到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else{//如果验证码不正确就跳回注册页面
            System.out.println("验证码["+ code +"]不正确");
            req.setAttribute("msg","验证码不正确");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

}
