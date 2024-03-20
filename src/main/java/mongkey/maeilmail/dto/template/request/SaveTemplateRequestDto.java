package mongkey.maeilmail.dto.template.request;

import lombok.Getter;
import mongkey.maeilmail.domain.Post;
import mongkey.maeilmail.domain.Template;

@Getter
public class SaveTemplateRequestDto {

    private Long admin_id;
    private String title;
    private String content;
    private Integer copy_count = 0;

    public Template toEntity(){
        return Template.builder()
                .admin_id(admin_id)
                .title(title)
                .content(content)
                .copy_count(copy_count)
                .build();
    }



    @Override
    public String toString() {
        return "SaveTemplateRequestDto{" +
                "admin_id=" + admin_id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}