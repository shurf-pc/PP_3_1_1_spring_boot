package web.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.model.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
}
