package mongkey.maeilmail.dto.post.response;

import lombok.Builder;
import lombok.Getter;
import mongkey.maeilmail.domain.Post;
import mongkey.maeilmail.domain.enums.CategoryType;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class AllPostResponseDto {
    private List<Post> allPostList;
}
