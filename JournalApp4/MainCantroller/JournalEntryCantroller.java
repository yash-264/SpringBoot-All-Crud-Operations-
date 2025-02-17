package yash.example.JournalApp4.MainCantroller;


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yash.example.JournalApp4.Entity.JournalEntry;
import yash.example.JournalApp4.Services.JournalEntryServices;

import java.util.List;

@RestController
@RequestMapping("/journal4")
public class JournalEntryCantroller {

    @Autowired
    private JournalEntryServices journalEntryServices;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryServices.findAll();
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntryServices.saveEntry(myEntry);
        return true;
    }

    @DeleteMapping
    public String deleteAll(){
        journalEntryServices.delete();
        return "deleted all";
    }

    @DeleteMapping("id/{myId}")
    public void deleteById(@PathVariable ObjectId myId){
        journalEntryServices.deleteById(myId);
    }

    @GetMapping("id/{myId}")
    public JournalEntry getById(@PathVariable ObjectId myId){
        return journalEntryServices.findById(myId).orElse(null);
    }

    @PutMapping("id/{myId}")
    public String update(@RequestBody JournalEntry newEntry,@PathVariable ObjectId myId){

        JournalEntry oldEntry=journalEntryServices.findById(myId).orElse(null);

        if (oldEntry != null){
            oldEntry.setEmployname(newEntry.getEmployname() != null &&!newEntry.getEmployname().equals("")? newEntry.getEmployname() : oldEntry.getEmployname());
            oldEntry.setDesignation(newEntry.getDesignation() != null && !newEntry.getDesignation().equals("")?newEntry.getDesignation():oldEntry.getDesignation());

        }
        journalEntryServices.saveEntry(oldEntry);
        return "Operation success";
    }
}
