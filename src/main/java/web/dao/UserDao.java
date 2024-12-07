package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    Long addUser(String name, String email);

    boolean deleteUser(Long id);

    boolean updateUser(User user);

    User getUser(Long id);

    List<User> getAllUsers();
}
