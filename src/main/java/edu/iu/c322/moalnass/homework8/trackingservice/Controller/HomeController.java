package edu.iu.c322.moalnass.homework8.trackingservice.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeController {
    //get HTTP localhost this will handle specific request
    @GetMapping
    public String greetings(){
        return "Greetings!";
    }
}
