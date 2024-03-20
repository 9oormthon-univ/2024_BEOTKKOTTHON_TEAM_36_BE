package mongkey.maeilmail.domain;

import jakarta.persistence.*;
import lombok.Builder;
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
    private Long id;

    @Column
    private Long admin_id;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column
    private Integer copy_count = 0;

    @Builder
    public Template(Long id, Long admin_id, String title, String content, Integer copy_count){
        this.id = id;
        this.admin_id = admin_id;
        this.title = title;
        this.content = content;
        this.copy_count = copy_count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCopy_count() {
        return copy_count;
    }

    public void setCopy_count(Integer copy_count) {
        this.copy_count = copy_count;
    }
}
