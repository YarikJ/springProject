package spring.impl.service;

import java.util.List;

import spring.impl.model.User;

public interface UserService {

    void add(User user);

    List<User> listUsers();
}
