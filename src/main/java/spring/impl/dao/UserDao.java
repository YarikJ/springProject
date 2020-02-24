package spring.impl.dao;

import java.util.List;

import spring.impl.model.User;

public interface UserDao {

    void add(User user);

    List<User> listUsers();

    User get(Long id);
}
