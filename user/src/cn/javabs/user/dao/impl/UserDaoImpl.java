package cn.javabs.user.dao.impl;

import cn.javabs.user.dao.UserDao;
import cn.javabs.user.entity.User;
import cn.javabs.user.util.DbcpUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    QueryRunner queryRunner = new QueryRunner(DbcpUtil.getDataSource());

    @Override
    public int addUser(User user) {
        try {
            return queryRunner.update("insert into book(username,password,sex) values (?,?,?)",
                    user.getUsername(),user.getPassword(),user.getSex());
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
