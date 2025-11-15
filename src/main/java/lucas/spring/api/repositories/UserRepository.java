package lucas.spring.api.repositories;

import lucas.spring.api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
