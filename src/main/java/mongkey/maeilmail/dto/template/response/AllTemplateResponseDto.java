package mongkey.maeilmail.dto.template.response;

import lombok.Builder;
import lombok.Getter;
import mongkey.maeilmail.domain.Template;

import java.util.List;

@Getter
@Builder
public class AllTemplateResponseDto {
    private List<Template> allTemplateList;
}
