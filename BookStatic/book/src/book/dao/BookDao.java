package book.dao;

import book.pojo.Book;

import java.util.List;

/**
 * @author hyc
 * @date 2020/8/25
 **/
public interface BookDao {
    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();
}
