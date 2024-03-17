package mongkey.maeilmail.dto.post;

import lombok.Getter;
import mongkey.maeilmail.domain.PostLike;

@Getter
public class LikePostRequestDto {

    private String user_id;
    private Long post_id;

    public PostLike toEntity(){
        return PostLike.builder()
                .user_id(user_id)
                .post_id(post_id)
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
