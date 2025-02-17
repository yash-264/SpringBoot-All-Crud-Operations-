package yash.example.JournalApp4.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "JournalEntry")
@Getter
@Setter
public class JournalEntry {

    @Id
    private ObjectId employid;

    private String employname;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmployname() {
        return employname;
    }

    public void setEmployname(String employname) {
        this.employname = employname;
    }

    private String designation;

    public ObjectId getEmployid() {
        return employid;
    }

    public void setEmployid(ObjectId employid) {
        this.employid = employid;
    }
}
