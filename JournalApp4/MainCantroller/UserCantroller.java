package yash.example.JournalApp4.MainCantroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yash.example.JournalApp4.Entity.User;
import yash.example.JournalApp4.Services.UserServices;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserCantroller {


    @Autowired
    private UserServices userServices;

    @GetMapping
    public List<User> getAllUser(){
        return userServices.findAll();
    }

    @PostMapping
    public boolean createNewUser(@RequestBody User newUser){
        userServices.saveEntry(newUser);
        return true;
    }

    @PutMapping("/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User user,@PathVariable String userName){

        User userInDb=userServices.findByUserName(userName);

        if(userInDb != null){
            userInDb.setUsername(user.getUsername());
            userInDb.setPassword(user.getPassword());
            userServices.saveEntry(userInDb);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
