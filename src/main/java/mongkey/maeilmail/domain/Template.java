package mongkey.maeilmail.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mongkey.maeilmail.common.domain.BaseTimeEntity;

@Getter
@NoArgsConstructor
@Table(name = "template")
@Entity
public class Template extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long template_id;

    @Column(length = 255, nullable = false)
    private String template_title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String template_content;

//    @Column(name = "user_id")
//    private String user_id;

}
