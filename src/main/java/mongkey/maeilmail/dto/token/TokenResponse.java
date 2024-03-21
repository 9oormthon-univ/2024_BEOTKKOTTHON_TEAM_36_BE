package mongkey.maeilmail.dto.token;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
//@NoArgsConstructor
public class TokenResponse {
    private String accessToken;
    private String tokenType;

    public TokenResponse(String accessToken, String tokenType) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }
}
