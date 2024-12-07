package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service(value = "useDAO")
@Transactional
public class UserServiceImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Long addUser(String name, String email) {
        return userDao.addUser(name, email);
    }

    @Override
    public boolean deleteUser(Long id) {
        return userDao.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
