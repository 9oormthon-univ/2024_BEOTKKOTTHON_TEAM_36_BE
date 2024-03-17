package mongkey.maeilmail.dto.post;

import lombok.Getter;
import mongkey.maeilmail.domain.Post;
import mongkey.maeilmail.domain.enums.CategoryType;

@Getter
public class UpdatePostRequestDto {
    private String user_id;
    private CategoryType category;
    private String title;
    private String content;
//        private PostType postType;

    //SavePostRequestDto를 실제 엔티티로 변환
    public Post toEntity(){
        return Post.builder()
                .user_id(user_id)
                .category(category)
                .title(title)
                .content(content)
                .build();
    }

    @Override
    public String toString() {
        return "SavePostRequestDto{" +
                "user_id='" + user_id + '\'' +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
