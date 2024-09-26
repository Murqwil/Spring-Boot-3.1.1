package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User updateUserById (int id,User userProperty);

    void removeUserById (int id);

    User saveUser (User user);
}
