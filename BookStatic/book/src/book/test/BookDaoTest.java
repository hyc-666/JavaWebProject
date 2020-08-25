package book.test;

import book.dao.BookDao;
import book.dao.impl.BookDaoImpl;
import book.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author hyc
 * @date 2020/8/25
 **/
public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();

    @Test
    public void addBook() {
        Book book = new Book(null,"Java封神之路",new BigDecimal(10),"胡逼瞎拽",15,68,null);
        //这里，id是自增的，给null值没有问题，而img_path是有默认路径的，null值也不会报错，比能切在方法钟已经针对了null值进行了处理
        bookDao.addBook(book);
    }

    @Test
    public void deleteBookById() {

        bookDao.deleteBookById(21);
    }

    @Test
    public void updateBook() {
        Book book = new Book(21,"Java入土之路",new BigDecimal(10),"胡逼瞎拽",15,68,null);
        bookDao.updateBook(book);
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }
}