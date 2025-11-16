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

    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> order = repository.findById(id);

        return order.get();
    }

    public Long persist(Order order) {
        return repository.save(order).getId();
    }

    public Long update(Order order) {
        Order orderBd = findById(order.getId());

        orderBd.setStatus(order.getStatus());
        orderBd.setMoment(order.getMoment());
        orderBd.setClient(order.getClient());

        return repository.save(orderBd).getId();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
