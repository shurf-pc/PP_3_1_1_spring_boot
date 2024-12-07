package web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Long addUser(String name, String email) {
        try {
            User user = new User(name, email);
            entityManager.persist(user);
            return user.getId();
        } catch (Exception e) {
            return -1L;
        }
    }

    @Override
    public boolean deleteUser(Long id) {
        try {
            User user = getUser(id);
            if (user != null) {
                entityManager.remove(user);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {
        try {
            entityManager.merge(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

}
