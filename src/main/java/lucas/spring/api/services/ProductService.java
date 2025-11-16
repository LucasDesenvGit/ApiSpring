package lucas.spring.api.services;

import lucas.spring.api.entities.Product;
import lucas.spring.api.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);

        return obj.get();
    }

    public Long persist(Product obj) {
        return repository.save(obj).getId();
    }

    public Long update(Product obj) {
        Product objBd = findById(obj.getId());

        objBd.setName(obj.getName());

        return repository.save(objBd).getId();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
