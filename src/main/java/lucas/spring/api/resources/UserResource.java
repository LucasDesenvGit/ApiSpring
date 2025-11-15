package lucas.spring.api.resources;

import lucas.spring.api.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        return ResponseEntity.ok().body
                (
                    new User(1, "Maria", "maria@gmail.com", "9999999", "1235")
                );
    }
    
}
