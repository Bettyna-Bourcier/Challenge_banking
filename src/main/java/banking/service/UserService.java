package banking.service;

import banking.model.User;
import banking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public List findAllUsers() {
        return userRepository.findAll();
    }

    public User findByClientNumber(String clientNumber) { return userRepository.findByClientNumber(clientNumber); }
}
