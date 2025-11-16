package lucas.spring.api.services;

import lucas.spring.api.entities.Category;
import lucas.spring.api.entities.User;
import lucas.spring.api.repositories.CategoryRepository;
import lucas.spring.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);

        return obj.get();
    }

    public Long persist(Category obj) {
        return repository.save(obj).getId();
    }

    public Long update(Category obj) {
        Category objBd = findById(obj.getId());

        objBd.setName(obj.getName());

        return repository.save(objBd).getId();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
