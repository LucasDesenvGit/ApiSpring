package lucas.spring.api.repositories;

import lucas.spring.api.entities.Order;
import lucas.spring.api.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
