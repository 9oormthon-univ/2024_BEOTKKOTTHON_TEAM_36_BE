package mongkey.maeilmail.dto.user.request;

import lombok.Getter;
import mongkey.maeilmail.domain.User;

@Getter
public class JoinUserRequestDto {
    private String login_id;
    private String password;
    private String name;
    private String email;

    public User toEntity(){
        return User.builder()
                .login_id(login_id)
                .password(password)
                .name(name)
                .email(email)
                .build();
    }
}
