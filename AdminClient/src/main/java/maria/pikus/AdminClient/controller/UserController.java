package maria.pikus.AdminClient.controller;

import maria.pikus.AdminClient.entity.User;
import maria.pikus.AdminClient.exception.ResourceNotFoundException;
import maria.pikus.AdminClient.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        User user =
                userRepo
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepo.save(user);
    }
}
