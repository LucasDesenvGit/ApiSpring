package lucas.spring.api.repositories;

import lucas.spring.api.entities.Payment;
import lucas.spring.api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
