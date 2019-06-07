package pl.kmachura.simplenotes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String sayHello() {
        return "Hi, this is SimplyNotes application. You can create a new SimpleNote by making a POST request to /api/simplenotes endpoint.";
    }
}
