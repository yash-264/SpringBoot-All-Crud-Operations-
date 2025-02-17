package yash.example.JournalApp4.Services;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import yash.example.JournalApp4.Entity.JournalEntry;
import yash.example.JournalApp4.Repository.JournalEntryRepository;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntryServices {

    @Autowired
    private JournalEntryRepository journalEntryRepository;


    public List<JournalEntry> findAll(){
        return journalEntryRepository.findAll();
    }


    public void saveEntry(JournalEntry myEntry){
        journalEntryRepository.save(myEntry);
    }

    public void delete(){
        journalEntryRepository.deleteAll();

    }

    public void deleteById(ObjectId id){
        journalEntryRepository.deleteById(id);

    }

    public Optional<JournalEntry> findById(ObjectId id){

        return journalEntryRepository.findById(id);
    }


}
