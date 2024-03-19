package mongkey.maeilmail.dto.user.request;

import lombok.Getter;
import mongkey.maeilmail.domain.User;

@Getter
public class LoginUserRequestDto {
    private String login_id;
    private String password;

    public User toEntity(){
        return User.builder()
                .login_id(login_id)
                .password(password)
                .build();
    }
}
