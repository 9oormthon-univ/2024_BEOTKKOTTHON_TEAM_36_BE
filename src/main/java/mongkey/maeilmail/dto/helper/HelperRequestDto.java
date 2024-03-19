package mongkey.maeilmail.dto.helper;

import lombok.*;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HelperRequestDto {
    private String model;
    private List<HelperRequestContentDto> messages;
    @Builder
    public HelperRequestDto(List<HelperRequestContentDto> messages) {
        this.messages = messages;
    }
}
