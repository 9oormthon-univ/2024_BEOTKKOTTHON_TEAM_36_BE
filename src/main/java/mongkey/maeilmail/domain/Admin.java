package mongkey.maeilmail.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mongkey.maeilmail.common.domain.BaseTimeEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Table(name = "admin")
@Entity
public class Admin extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private Long id;

    @Column(length = 255, nullable = false)
    private String employee_number;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(length = 320)
    private String email;

    @Column(length = 255)
    private String name;

    @Column
    private Integer access_level;

    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
    private List<Template> templateList = new ArrayList<>();

    @Builder
    public Admin (Long id, String employee_number, String password, String email, String name, Integer access_level, List<Template> templateList){
        this.id = id;
        this.employee_number = employee_number;
        this.password = password;
        this.email = email;
        this.name = name;
        this.access_level = access_level;
        this.templateList = templateList;
    }
}
