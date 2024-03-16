package mongkey.maeilmail.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class HelperRequestDto {
    private String model;

    private String prompt;

    private float temperature;

    @Builder
    HelperRequestDto(String model, String prompt, float temperature) {
        this.model = model;
        this.prompt = prompt;
        this.temperature = temperature;
    }

}
