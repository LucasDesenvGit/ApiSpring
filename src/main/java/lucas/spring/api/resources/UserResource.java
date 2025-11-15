package lucas.spring.api.resources;

import lucas.spring.api.entities.User;
import lucas.spring.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

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

}
