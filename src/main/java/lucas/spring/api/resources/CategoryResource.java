package lucas.spring.api.resources;

import lucas.spring.api.entities.Category;
import lucas.spring.api.entities.User;
import lucas.spring.api.services.CategoryService;
import lucas.spring.api.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    private CategoryService service;

    public CategoryResource(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){

        List<Category> categories = service.findAll();

        return ResponseEntity.ok().body(categories);
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){

        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody Category obj){
        return ResponseEntity.ok().body(service.persist(obj));
    }

    @PutMapping
    public ResponseEntity<Long> update(@RequestBody Category obj){
        return ResponseEntity.ok().body(service.update(obj));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.ok().body(null);
    }

}
