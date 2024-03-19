package mongkey.maeilmail.dto.helper;

import lombok.*;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HelperToGptRequestDto {
    private String model;
    private List<HelperRequestContentDto> messages;

    @Builder
    public HelperToGptRequestDto(String  model, List<HelperRequestContentDto> messages) {
        this.model = model;
        this.messages = messages;
    }
}
