package cn.javabs.user.service.impl;

import cn.javabs.user.dao.UserDao;
import cn.javabs.user.dao.impl.UserDaoImpl;
import cn.javabs.user.entity.User;
import cn.javabs.user.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao= new UserDaoImpl();
    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }
}
