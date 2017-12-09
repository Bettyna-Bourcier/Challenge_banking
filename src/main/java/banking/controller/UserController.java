package banking.controller;

import banking.model.User;
import banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    // Retrieve a user and its outgoings by its client number
    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByClientNumber() {
        Object clientNumber = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findByClientNumber(clientNumber.toString());
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}
