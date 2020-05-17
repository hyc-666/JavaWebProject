package book.dao.impl;

import book.dao.UserDao;
import book.pojo.User;

/**
 * @author hyc
 * @date 2020/5/17
 **/
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select * from t_user where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByName_password(String username, String password) {
        String sql = "select * from t_user where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user values(null,?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
