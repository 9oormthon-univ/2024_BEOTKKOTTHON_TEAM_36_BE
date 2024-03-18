package mongkey.maeilmail.repository;

import mongkey.maeilmail.domain.Admin;
import mongkey.maeilmail.domain.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
