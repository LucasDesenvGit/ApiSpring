package lucas.spring.api.services;

import lucas.spring.api.entities.Order;
import lucas.spring.api.entities.User;
import lucas.spring.api.repositories.OrderRepository;
import lucas.spring.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> order = repository.findById(id);

        return order.get();
    }
}
