package book.web;

import book.pojo.Book;
import book.service.BookService;
import book.service.impl.BookServiceImpl;
import book.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**  图书模块的Servlet
 * @author hyc
 * @date 2020/8/26
 **/
public class BookServlet extends BaseServlet {

    private BookService bookService = new BookServiceImpl();

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.获取请求的参数,并封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        //2。使用bookService层将如书信息存储到数据库
        bookService.addBook(book);
        //刷新数据并将请求页面跳转到图书管理页面
//        req.getRequestDispatcher("manager/bookServlet?action=list").forward(req,resp);

//        req.getRequestDispatcher("/manager/book_manager.jsp").forward(req,resp);
        //这里请求转发时，会导致用户按下功能键F5后将最后一次请求的参数发送，会造成重复添加图书的bug，所以不能使用请求转发
        //而应该使用请求重定向，这样是两次请求，第二次请求只会调用list的查询操作而不会重发添加图书
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1，获取请求的参数和图书id信息
        String id = req.getParameter("id");
        //记得将字符串转为Integer型
        //2.调用bookService层删除图书
        bookService.deleteBookById(Integer.parseInt(id));
        //3.请求重定向到图书管理页面
        resp.sendRedirect(req.getContextPath() + "/manager/bookServlet?action=list");
    }

    public void update(HttpServletRequest req, HttpServletResponse resp){}

    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过BookService获取图书信息
        List<Book> books = bookService.queryBooks();
        //2.将图书信息保存到request域中
        req.setAttribute("books",books);
        //3.将请求转变发到/pages/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
