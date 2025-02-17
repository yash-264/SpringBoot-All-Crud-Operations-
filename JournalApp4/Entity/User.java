package yash.example.JournalApp4.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "user")
@Data
public class User {

    public @NonNull String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @Id
    @NonNull
    private ObjectId id;

    public @NonNull String getPassword() {
        return Password;
    }

    public void setPassword(@NonNull String password) {
        Password = password;
    }

    @NonNull
    @Indexed(unique = true)
    private String username;
    @NonNull
    private String Password;

    public @NonNull ObjectId getId() {
        return id;
    }

    public void setId(@NonNull ObjectId id) {
        this.id = id;
    }

    @DBRef
    private  List<JournalEntry> journalEntries=new ArrayList<>();


}
