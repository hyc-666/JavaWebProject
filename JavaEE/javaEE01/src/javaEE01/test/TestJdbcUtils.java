package javaEE01.test;

import javaEE01.utils.JdbcUtils;
import org.junit.Test;

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
