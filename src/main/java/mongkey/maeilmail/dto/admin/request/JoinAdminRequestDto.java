package mongkey.maeilmail.dto.admin.request;

import lombok.Getter;
import mongkey.maeilmail.domain.Admin;

@Getter
public class JoinAdminRequestDto {
    private String employee_number;
    private String password;
    private String email;
    private String name;

    public Admin toEntity(){
        return Admin.builder()
                .employee_number(employee_number)
                .password(password)
                .email(email)
                .name(name)
                .build();
    }

    @Override
    public String toString() {
        return "JoinAdminRequestDto{" +
                "employee_number='" + employee_number + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
