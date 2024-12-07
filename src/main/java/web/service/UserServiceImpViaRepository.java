package web.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;

@Service(value = "useRepository")
@Transactional
public class UserServiceImpViaRepository implements UserService {
    UserRepository userRepository;

    public UserServiceImpViaRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Long addUser(String name, String email) {
        try {
            User resultUser = userRepository.save(new User(name, email));
            return resultUser.getId();
        } catch (Exception e) {
            return -1L;
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).isPresent() ? userRepository.findById(id).get() : null;
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            return null;
        }
    }
}
