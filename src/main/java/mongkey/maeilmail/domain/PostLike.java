package mongkey.maeilmail.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mongkey.maeilmail.common.domain.BaseTimeEntity;

@Getter
@Setter
@NoArgsConstructor
@IdClass(PostLike.class)
@Table(name = "post_like")
@Entity
public class PostLike extends BaseTimeEntity {
    @Id
    @Column(nullable = false)
    private String user_id;

    @Id
    @Column(nullable = false)
    private Long post_id;

    @Builder
    public PostLike(String user_id, Long post_id){
        this.user_id = user_id;
        this.post_id = post_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    @Override
    public String toString() {
        return "PostLike{" +
                "user_id=" + user_id +
                ", post_id=" + post_id +
                '}';
    }
}
