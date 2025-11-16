package lucas.spring.api.resources;

import lucas.spring.api.entities.Category;
import lucas.spring.api.entities.Product;
import lucas.spring.api.services.CategoryService;
import lucas.spring.api.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    private ProductService service;

    public ProductResource(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){

        List<Product> categories = service.findAll();

        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){

        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody Product obj){
        return ResponseEntity.ok().body(service.persist(obj));
    }

    @PutMapping
    public ResponseEntity<Long> update(@RequestBody Product obj){
        return ResponseEntity.ok().body(service.update(obj));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().body(null);
    }

}
