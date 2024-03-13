package mongkey.maeilmail.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mongkey.maeilmail.common.domain.BaseTimeEntity;

@Getter
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(length = 255, nullable = false)
    private String login_id;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 255)
    private String nickname;

    @Column(length = 320)
    private String email;

    @Builder
    public User(String login_id, String password, String nickname, String email){
        this.login_id = login_id;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }
}
