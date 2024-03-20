package mongkey.maeilmail.dto.post.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class PostDto {
    private Long post_id;
    private String writer;
    private String title;
    private String content;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
