package mongkey.maeilmail.repository;

import jakarta.persistence.EntityListeners;
import jakarta.transaction.Transactional;
import mongkey.maeilmail.domain.Post;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//@EntityListeners(AuditingEntityListener.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class PostRepositoryTest {
   @Autowired
   private PostRepository postRepository;
   private Post post;

    //
    @BeforeEach
    public void beforeEach(){
        //        post = Post
//                .builder()
//                .post_id(1L)
//                .post_title("제목")
//                .post_content("내용")
//                .user_id("사용자 ID")
//                .like_cnt(0L)
//                .unlike_cnt(0L)
//                .build();
    }
    @AfterEach
    public void afterEach() {
//        // 테스트가 종료될 때마다 객체 초기화
//        postRepository.clearStore();
    }

    //Order(1)으로 실행순서 지정
    @DisplayName("질문 등록 테스트")
    @Test
    @Order(1)
    public void testSave() {
        // given
//        String randomCode = RandomStringUtils.randomAlphanumeric(15);
        post = Post
                .builder()
                .post_id(2L)
                .post_title("제목2")
                .post_content("내용2")
                .user_id("사용자 ID2")
                .like_cnt(1L)
                .unlike_cnt(1L)
                .build();
        // when
        Post savedPost = postRepository.save(post);
//        Long postId = savedPost.getPost_id();
        System.out.println("savedPost = " + savedPost);
//        System.out.println("postId = " + postId);
//        assertThat(savedPost.getPost_id()).isEqualTo(1);
    }
}