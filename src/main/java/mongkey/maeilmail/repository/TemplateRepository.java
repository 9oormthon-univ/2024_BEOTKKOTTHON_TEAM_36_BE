package mongkey.maeilmail.repository;

import mongkey.maeilmail.domain.Template;
import mongkey.maeilmail.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TemplateRepository extends JpaRepository<Template, Long> {
    //Create
    Template save(Template template);

    //Read
    List<Template> findAll();
    Optional<Template> findById(Long id);

    //Update => 엔티티를 수정할 때는 해당 엔티티를 가져와서 필드 값을 변경한 뒤에 저장하는 방식


    //Delete
    void deleteById(Long id);
    void delete(Template template);
    void deleteAll();
}
