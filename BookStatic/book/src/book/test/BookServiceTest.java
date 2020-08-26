package book.test;

import book.pojo.Book;
import book.service.BookService;
import book.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author hyc
 * @date 2020/8/26
 **/
public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        Book book = new Book(null,"九阳神功",new BigDecimal(9999),"佚名",13,19,null);
        bookService.addBook(book);
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(25);
    }

    @Test
    public void updateBook() {
        Book book = new Book(25,"九阳神功",new BigDecimal(9999),"佚名",456,0,null);
        bookService.updateBook(book);
    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(23));
    }

    @Test
    public void queryBooks() {
        for (Book book : bookService.queryBooks()){
            System.out.println(book);
        }
    }
}