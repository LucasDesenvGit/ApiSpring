package lucas.spring.api.repositories;

import lucas.spring.api.entities.Order;
import lucas.spring.api.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
