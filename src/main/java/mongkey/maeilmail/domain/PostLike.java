package mongkey.maeilmail.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mongkey.maeilmail.common.domain.BaseTimeEntity;

@Getter
@NoArgsConstructor
@Table(name = "post_like")
@Entity
public class PostLike extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Builder
    public PostLike(User user, Post post){
        this.user = user;
        this.post = post;
    }

//    @Builder
//    public PostLike(String user_id, Long post_id){
//        this.user_id = user_id;
//        this.post_id = post_id;
//    }
//
//    public String getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(String user_id) {
//        this.user_id = user_id;
//    }
//
//    public Long getPost_id() {
//        return post_id;
//    }
//
//    public void setPost_id(Long post_id) {
//        this.post_id = post_id;
//    }
//
//    @Override
//    public String toString() {
//        return "PostLike{" +
//                "user_id=" + user_id +
//                ", post_id=" + post_id +
//                '}';
//    }
}
