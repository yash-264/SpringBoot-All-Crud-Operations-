package yash.example.JournalApp4.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import yash.example.JournalApp4.Entity.User;

public interface UserRepository extends MongoRepository<User,ObjectId> {

     User findByusername(String username);
}
