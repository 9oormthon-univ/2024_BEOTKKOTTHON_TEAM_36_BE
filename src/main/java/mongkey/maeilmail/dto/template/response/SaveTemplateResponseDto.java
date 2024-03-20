package mongkey.maeilmail.dto.template.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SaveTemplateResponseDto {
    private Long id;
    private String title;
    private String content;
}
