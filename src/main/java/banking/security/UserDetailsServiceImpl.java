package banking.security;

import banking.model.User;
import banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String clientNumber) throws UsernameNotFoundException {
        User user = userService.findByClientNumber(clientNumber);
        if (user == null) {
            throw new UsernameNotFoundException(clientNumber);
        }
        return new org.springframework.security.core.userdetails.User(user.getClientNumber(), user.getPassword(), emptyList());
    }
}