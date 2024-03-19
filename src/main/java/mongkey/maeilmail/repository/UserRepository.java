package mongkey.maeilmail.repository;

import mongkey.maeilmail.domain.Post;
import mongkey.maeilmail.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * FROM users u "+
            "WHERE u.login_id = :login_id" , nativeQuery = true)
    Optional<User> findByLoginId(String login_id);

//    save(), findById(), existsById(), count(), deleteById(), delete(), deleteAll()
//    findOne(), findAll(), count(), exists()
}
