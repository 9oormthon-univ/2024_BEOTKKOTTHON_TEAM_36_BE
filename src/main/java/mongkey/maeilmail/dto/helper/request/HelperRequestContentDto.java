package mongkey.maeilmail.dto.helper.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HelperRequestContentDto {
    private String role;

    private String content;

    @Builder
    HelperRequestContentDto(String role, String content) {
        this.role = role;
        this.content = content;
    }

}
