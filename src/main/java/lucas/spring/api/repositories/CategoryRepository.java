package lucas.spring.api.repositories;

import lucas.spring.api.entities.Category;
import lucas.spring.api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
