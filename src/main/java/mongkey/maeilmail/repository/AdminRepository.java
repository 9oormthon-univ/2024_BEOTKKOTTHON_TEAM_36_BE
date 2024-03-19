package mongkey.maeilmail.repository;

import mongkey.maeilmail.domain.Admin;
import mongkey.maeilmail.domain.PostLike;
import mongkey.maeilmail.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query(value = "SELECT * FROM admin ad "+
            "WHERE ad.employee_number = :employee_number" , nativeQuery = true)
    Optional<Admin> findByEmployeeNumber(String employee_number);
}
