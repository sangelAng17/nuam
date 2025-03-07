package co.com.bvc.nuam.controller;

import co.com.bvc.nuam.persistence.entity.User;
import co.com.bvc.nuam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<ArrayList<User>> findAll(){
        try{
            return ResponseEntity.ok(userService.findAll());
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findAllById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(userService.findById(id));
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<User> findAllById(@RequestBody User user){
        try{
            return ResponseEntity.ok(userService.UpdateById(user));
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try{
            userService.deteteById(id);
            return ResponseEntity.ok("");
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<User> insert(@RequestBody User user){
        try{
            return ResponseEntity.ok(userService.save(user));
        }catch (Exception e)
        {
            return ResponseEntity.notFound().build();
        }
    }



}
