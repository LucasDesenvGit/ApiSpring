package lucas.spring.api.resources;

import lucas.spring.api.entities.User;
import lucas.spring.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){

        List<User> users = userService.findAll();

        return ResponseEntity.ok().body(users);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){

        User users = userService.findById(id);
        return ResponseEntity.ok().body(users);
    }

    @PostMapping
    public ResponseEntity<URI> save(@RequestBody User user){
        Long id = userService.persist(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri();

        return ResponseEntity.ok().body(uri);
    }

    @PutMapping
    public ResponseEntity<Long> update(@RequestBody User user){
        return ResponseEntity.ok().body(userService.update(user));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        userService.deleteById(id);
        return ResponseEntity.ok().body(null);
    }

}
