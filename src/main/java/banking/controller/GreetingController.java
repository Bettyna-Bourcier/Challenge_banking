package banking.controller;

import java.util.concurrent.atomic.AtomicLong;

import banking.Greeting;
import banking.model.User;
import banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="Expertus") String name) {
        return new Greeting(
                counter.incrementAndGet(),
                String.format(template, name)
        );
    }
}