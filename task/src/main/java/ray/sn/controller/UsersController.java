package ray.sn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ray.sn.services.UserService;
import ray.sn.entites.Users;


@RestController
@RequestMapping("users")
public class UsersController {

     private UserService userService;

    public UsersController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Users addUsers(@RequestBody Users users){
        return userService.addUsers(users);
    }

     @GetMapping("/all")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{email}")
    public Optional<Users> getUserBy(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @PostMapping("/register")
    public String register(@RequestBody Users user) {
        userService.registUsers(user.getEmail(), user.getPassword());
        return "Utilisateur enregistré avec succès !";
    }

}
