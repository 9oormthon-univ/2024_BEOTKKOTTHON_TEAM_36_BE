package mongkey.maeilmail.repository;

import mongkey.maeilmail.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    User findByUsername(String username);
//    boolean existsByNickname(String nickname);
//
//    Optional<User> findByNickname(String nickname);

//    @Query("SELECT * FROM myboard")
//    Optional<User> findBySocial_id(String social_id);

//    @Query("SELECT a FROM myboard a")
//    List<User> findAll();
//    Optional<User> findById(String id);

//    User save(User user);

//    void deleteById(Long id);

//    save(), findById(), existsById(), count(), deleteById(), delete(), deleteAll()
//    findOne(), findAll(), count(), exists()
}
