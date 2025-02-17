package yash.example.JournalApp4.MainCantroller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {


    @GetMapping("check")
    public String health(){

        return "Server Is Working";
    }
}
