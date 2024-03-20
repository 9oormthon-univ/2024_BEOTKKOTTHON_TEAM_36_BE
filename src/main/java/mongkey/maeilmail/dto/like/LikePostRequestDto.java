package mongkey.maeilmail.dto.like;

import lombok.Getter;
import mongkey.maeilmail.domain.Post;
import mongkey.maeilmail.domain.PostLike;
import mongkey.maeilmail.domain.User;

@Getter
public class LikePostRequestDto {

    private Long user_id;
    private Long post_id;

    public PostLike toEntity(User user, Post post){
        return PostLike.builder()
                .user(user)
                .post(post)
                .build();
    }

    @Override
    public String toString() {
        return "LikePostRequestDto{" +
                "user_id='" + user_id + '\'' +
                ", post_id=" + post_id +
                '}';
    }
}
