package spring.impl.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import spring.impl.dao.UserDao;
import spring.impl.model.User;
import spring.impl.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
}
