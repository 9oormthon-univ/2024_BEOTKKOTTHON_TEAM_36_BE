package mongkey.maeilmail.dto.helper;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HelperResponseDto {
    private String user_id;
    private String subject;
    private String greeting;
    private String body;
    private String closing;
}
