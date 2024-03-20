package mongkey.maeilmail.dto.helper.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HelperRetryResponseDto {
    private Long user_id;
    private String version1;
    private String version2;
    private String version3;
}
