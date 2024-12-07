package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    Long addUser(String name, String email);

    boolean deleteUser(Long id);

    boolean updateUser(User user);

    User getUser(Long id);

    List<User> getAllUsers();
}
