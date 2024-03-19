package mongkey.maeilmail.dto.admin.request;

import lombok.Getter;
import mongkey.maeilmail.domain.Admin;
import mongkey.maeilmail.domain.User;

@Getter
public class LoginAdminRequestDto {
    private String employee_number;
    private String password;

    public Admin toEntity(){
        return Admin.builder()
                .employee_number(employee_number)
                .password(password)
                .build();
    }
}
