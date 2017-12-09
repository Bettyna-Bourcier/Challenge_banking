package banking.controller;

import banking.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController {

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return new ResponseEntity<User>(HttpStatus.OK);
    }
}
