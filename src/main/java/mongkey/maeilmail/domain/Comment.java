package mongkey.maeilmail.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import mongkey.maeilmail.common.domain.BaseTimeEntity;

@Getter
@NoArgsConstructor
@Table(name = "comment")
@Entity
public class Comment extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "")
    @Column
    private Long user_id;

    @Column
    private Long post_id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public Comment(Long id, Long user_id, Long post_id, String content){
        this.id = id;
        this.user_id = user_id;
        this.post_id = post_id;
        this.content = content;
    }
}