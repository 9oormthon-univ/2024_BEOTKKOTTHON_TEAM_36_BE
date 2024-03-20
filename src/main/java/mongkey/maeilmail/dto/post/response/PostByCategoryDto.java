package mongkey.maeilmail.dto.post.response;

import lombok.Builder;
import lombok.Getter;
import mongkey.maeilmail.domain.Post;
import mongkey.maeilmail.domain.enums.CategoryType;
import mongkey.maeilmail.dto.PageInfo;

import java.util.List;

@Getter
@Builder
public class PostByCategoryDto {
    private CategoryType categoryType;
    private List<Post> postList;
    private PageInfo pageInfo;
}
