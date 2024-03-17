package mongkey.maeilmail.repository;

import mongkey.maeilmail.domain.Post;
import mongkey.maeilmail.domain.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike, Integer> {
    @Query(value = "SELECT * FROM post_like pl " +
            "WHERE pl.post_id = :post_id "+
            "AND pl.user_id = :user_id", nativeQuery = true)
    Optional<PostLike> findByPostIdAndUserId(Long post_id, String user_id);

//    @Query(value = "SELECT * FROM postLike pl " +
//            "WHERE pl.id = :post_id "+
//            "AND pl.user_id = :user_id", nativeQuery = true)

    @Query(value = "DELETE * FROM post_like pl " +
            "WHERE pl.post_id = :post_id "+
            "AND pl.user_id = :user_id", nativeQuery = true)
    void deleteByPostIdAndUserId(String user_id, Long post_id);

//    @Query(value = "DELETE * FROM post_like pl " +
//            "WHERE pl.post_id = :post_id "+
//            "AND pl.user_id = :user_id", nativeQuery = true)
}

