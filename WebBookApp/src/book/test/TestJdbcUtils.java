package book.test;

import book.utils.JdbcUtils;
import org.junit.Test;

import java.util.stream.StreamSupport;

/**
 * @author hyc
 * @date 2020/5/17
 **/
public class TestJdbcUtils {
    @Test
    public void testJdbcUtils(){
        System.out.println(JdbcUtils.getConnection());
    }
}
