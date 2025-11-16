package lucas.spring.api.services;

import lucas.spring.api.entities.User;
import lucas.spring.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository repository;
    public UserService (UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> user = repository.findById(id);

        return user.get();
    }

    public Long persist(User user) {
        return repository.save(user).getId();
    }

    public Long update(User user) {
        User userBd = repository.getReferenceById(user.getId());

        updateData(userBd, user);

        return repository.save(userBd).getId();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
