package book.service;

import book.pojo.Book;

import java.util.List;

/**
 * @author hyc
 * @date 2020/8/25
 **/
public interface BookService {
    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();
}
