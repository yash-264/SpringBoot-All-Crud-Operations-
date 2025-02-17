package yash.example.JournalApp4.Services;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import yash.example.JournalApp4.Entity.JournalEntry;
import yash.example.JournalApp4.Entity.User;
import yash.example.JournalApp4.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Component
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }


    public void saveEntry(User myEntry){
        userRepository.save(myEntry);
    }

    public void delete(){
        userRepository.deleteAll();

    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);

    }

    public User findByUserName(String username){
        return userRepository.findByusername(username);
    }
}
