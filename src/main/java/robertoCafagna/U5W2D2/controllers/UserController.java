package robertoCafagna.U5W2D2.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import robertoCafagna.U5W2D2.entities.User;
import robertoCafagna.U5W2D2.payloads.UserPayload;
import robertoCafagna.U5W2D2.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    // 1. GET http://localhost:3001/users --> 200 OK    ARRAY DI UTENTI
    @GetMapping
    public List<User> findAll() {
        return this.userService.findAll();
    }

    //2. POST http://localhost:3001/users (+payload) --> 201 CREATED     UTENTE APPENA CREATO

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody UserPayload body) {
        return this.userService.save(body);
    }

    // 3. GET  http://localhost:3001/users/{userId} --> 200 OK  UTENTE TROVATO

    @GetMapping("/{userId}")
    public User findById(@PathVariable long userId) {
        return this.userService.findById(userId);
    }

    // 4. PUT http://localhost:3001/users/{userId} (+payload) --> 200 OK  UTENTE AGGIORNATO
    @PutMapping("/{userId}")
    public User findByIdAndUpdate(@PathVariable long userId, @RequestBody UserPayload body) {
        return this.userService.findByIdAndUpdate(userId, body);
    }

    //5.DELETE http://localhost:PORT/users/{userId} --> 204 NO CONTENT
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable long userId) {
        this.userService.findAndDelete(userId);
    }
}
