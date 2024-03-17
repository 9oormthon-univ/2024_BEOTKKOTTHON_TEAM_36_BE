package mongkey.maeilmail.repository;

import mongkey.maeilmail.domain.Post;
import mongkey.maeilmail.domain.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//@Primary
public interface PostRepository extends JpaRepository<Post, Long> {
        //모든 게시물 찾기
        List<Post> findAll();
//
        //게시물 id로 찾기
//        Optional<Post> findById(String id);
//
//        //게시물 id로 삭제
//        void deleteById(Long id);
//        @Query(value = "SELECT * FROM post p " +
//                "WHERE p.friendship_status = 'ACCEPT' " +
//                "AND (f.to_user = :users_id OR f.from_user = :users_id)", nativeQuery = true)
        @Query(value = "SELECT * FROM post p " +
                "WHERE p.id = :post_id "+
                "AND p.user_id = :user_id", nativeQuery = true)
        Optional<Post> findByPostIdAndUserId(Long post_id, String user_id);
}
